create or replace PACKAGE BODY       proyecto_bus
IS
       
  /***************************************************************
  PROCEDURE filtrar_transmisiones
  *****************************************************************/
  PROCEDURE filtrar_transmisiones (
        codigo_entidad      IN  VARCHAR2,   -- Códigos de la entidades
        fecha_inicio        IN  DATE,       -- Fecha de inicio
        fecha_fin           IN  DATE,       -- Fecha de fin
        tipo_mensaje        IN  VARCHAR2,   -- Códigos de los tipos de mensaje
        tipo_documento      IN  VARCHAR2,   -- Códigos de los tipos de document
        numero_documento    IN  VARCHAR2,   -- Número de documento
        tipo_transmision    IN  NUMBER,     -- Tipos de transmisión
        tipo_incidente      IN  VARCHAR2,   -- Tipos de incidente
        estado_vc           IN  VARCHAR2,   -- Estados en VUCE-CENTRAL
        estado_ve           IN  VARCHAR2,   -- Estados en VUCE-ENTIDAD
        vc_id               IN  VARCHAR2,   -- VC_ID    transmision.vc_id
        ve_id               IN  VARCHAR2,   -- VE_ID    transmision.ve_id
        tCursor             OUT cur_Tabla   -- Cursor de salida
        )
    IS
        t_Cursor1          cur_Tabla;
    t_Cursor2          cur_Tabla;
    numRows           NUMBER;
    v_codigo_entidad  VARCHAR2(50);
    v_codigo_mensaje  VARCHAR2(50);
    v_tipo_mensaje    VARCHAR2(100);
    v_tipo_documento    VARCHAR2(50);
    v_numero_documento    VARCHAR2(50);
    v_tipo_transmision  VARCHAR2(50);
    v_tipo_incidente    VARCHAR2(50);
    v_vc_id    VARCHAR2(50);
    v_ve_id    VARCHAR2(50);
    v_vc_estado    VARCHAR2(50);
    v_ve_estado    VARCHAR2(50);
  
    v_tipo_tmp   NUMBER(1,0);
    v_entidad_id_tmp VARCHAR2(10); 
    v_entidad_siglas_tmp VARCHAR2(50);
    v_mensaje_tipo_tmp VARCHAR2(5);
    v_mensaje_nom_tmp VARCHAR2(100);
    v_adjunto_id_mensaje_tmp NUMBER(12,0); 
    v_adjunto_id_ebxml_tmp NUMBER(12,0); 
    v_error_tmp CLOB;
    v_vc_id_tmp NUMBER(10,0); 
    v_ve_id_tmp NUMBER(10,0);  
    v_vc_estado_tmp NUMBER(2,0); 
    v_ve_estado_tmp NUMBER(2,0); 
    v_vc_estado_nom_tmp VARCHAR2(100 byte);
    v_ve_estado_nom_tmp VARCHAR2(100 byte);
    v_fecha_registro_salida_tmp DATE;
    v_fecha_actualiz_salida_tmp DATE;
    v_antiguedad_salida_tmp NUMBER(10,0); 
    v_fecha_registro_entrada_tmp DATE;
    v_fecha_actualiz_entrada_tmp DATE;
    v_antiguedad_entrada_tmp NUMBER(10,0);
    v_subtipo_xml_tmp  NUMBER(1,0);
    v_tiene_incidente_tmp   NUMBER(1,0);
    v_tipo_incidente_tmp NUMBER(1,0);
    v_documento_tipo_tmp VARCHAR2(50);
    v_documento_nom_tmp  VARCHAR2(50); 
    v_documento_num_tmp  VARCHAR2(50); 
    v_formato_tmp VARCHAR2(10);
    v_adjunto_mensaje_tmp BLOB;
    v_adjunto_ebxml_tmp BLOB;
    v_eve_estadotmp_tmp  NUMBER(2,0);     
    v_sla_valor_tmp NUMBER(5,0);
        v_Sql             CLOB;
        v_Sql2            CLOB;
    v_param_max_dias  NUMBER(2,0);
    BEGIN
    
    --Obtener el número de dias maximo para el filtro de transmisiones
    select  TO_NUMBER(c.valor)
        into v_param_max_dias
      from vcobj.constante c
      where c.codigo='PROYECTO_BUS_MAX_DIAS';
    
    /*
    Validación inicial de parámetros
    - Si se busca transmisiones con incidentes 
      --> No es obligatorio seleccionar la entidad. 
    - Si se busca transmisiones con y sin incidentes
      --> Sí es obligatorio seleccionar la entidad.
      --> Sí obligatorio un período de búsqueda de rango de 2 meses (Parametro en la tabla MAESTRO_DET)
    */
    IF tipo_transmision = 1 THEN
      IF codigo_entidad = '%' THEN
        raise_application_error( -20001, 'Se recomienda seleccionar solo una entidad.' );
      END IF;
      IF (fecha_fin - fecha_inicio) > v_param_max_dias THEN
        raise_application_error( -20001, 'Se recomienda afinar el rango de fechas a menos de '||v_param_max_dias||' días.' );
      END IF;
    END IF;
    
        -- Validaciones para Parametro 1 (Códigos de la entidades)
        v_codigo_entidad := devolverParametro('e.entidad_id',codigo_entidad,false);
    -- Validaciones para Parametro 4 (Códigos de los tipos de mensaje)  Ns  
    v_tipo_mensaje := devolverParametro('c.transaccion',tipo_mensaje,true);    
    -- Validaciones para Parametro 5 (Tipo de Documento)        
    v_tipo_documento := devolverParametro('a.documento_tipo',tipo_documento,true);  
    -- Validaciones para Parametro 6 (Número de documento)      
    v_numero_documento := devolverParametro('a.documento_num',numero_documento,true);        
    -- Validaciones para Parametro 8 (Tipos de incidente)
    v_tipo_incidente := devolverParametro('a.tipo_incidente',tipo_incidente,true);    
    -- Validaciones para Parametro 9 (Estados en VUCE-CENTRAL)
        v_vc_estado := devolverParametro('a.evc_id',estado_vc,true);    
    -- Validaciones para Parametro 10 (Estados en VUCE-ENTIDAD)
        v_ve_estado := devolverParametro('a.eve_id',estado_ve,true);    
    -- Validaciones para Parametro 11 (VC_ID)
    v_vc_id := devolverParametro('a.vc_id',vc_id,true);    
    -- Validaciones para Parametro 12 (VE_ID)
        v_ve_id := devolverParametro('a.ve_id',ve_id,true);
    
    dbms_output.put_line('[LOG - filtrar_transmisiones] v_codigo_entidad: ' || v_codigo_entidad);
    dbms_output.put_line('[LOG - filtrar_transmisiones] v_tipo_mensaje: ' || v_tipo_mensaje);
    dbms_output.put_line('[LOG - filtrar_transmisiones] v_tipo_documento: ' || v_tipo_documento);
    dbms_output.put_line('[LOG - filtrar_transmisiones] v_numero_documento: ' || v_numero_documento);
    dbms_output.put_line('[LOG - filtrar_transmisiones] v_tipo_incidente: ' || v_tipo_incidente);
    dbms_output.put_line('[LOG - filtrar_transmisiones] v_estado_vc: ' || v_vc_estado);
    dbms_output.put_line('[LOG - filtrar_transmisiones] v_estado_ve: ' || v_ve_estado);
    dbms_output.put_line('[LOG - filtrar_transmisiones] v_vc_id: ' || v_vc_id);
    dbms_output.put_line('[LOG - filtrar_transmisiones] v_ve_id: ' || v_ve_id);
    
    -- QUERY para crear la tabla temporal con los datos de iniciales de consulta
    SELECT 'select '||
                ' (CASE WHEN c.flujo_transaccion IN (1,3,5,7,10) THEN '|| 2 ||' ELSE '|| 1 || ' END) as TIPO,'||
                ' a.entidad_id as ENTIDAD_ID,'||
                ' e.siglas as ENTIDAD_SIGLAS,'||
                ' c.transaccion as MSJ_TIPO,'||
                ' c.descripcion as MSJ_NOM,'||
                ' b.mensaje as ADJ_ID_MENSAJE,'||
                ' b.ebxml as ADJ_ID_EBXML,'||
                ' f.mensaje as ERROR,'||
                ' a.vc_id as VC_ID,'||
                ' null as VE_ID,'||
                ' a.evc_id as VC_ESTADO,'||
                ' null as VE_ESTADO,'||
                ' d.descripcion as VC_ESTADO_NOM,'||
                ' null as VE_ESTADO_NOM,'||
                ' a.fecha_registro as FECHA_REG_SALIDA,'||
                ' a.fecha_actualizacion as FECHA_ACT_SALIDA,'||
                ' round((sysdate-a.fecha_registro)*24*60) as ANTIG_SALIDA,'||
                ' null as FECHA_REG_ENTRADA,'||
                ' null as FECHA_ACT_ENTRADA,'||
                ' null as ANTIG_ENTRADA,'||
                ' (CASE '||
                '   WHEN (dbms_lob.Instr(j.archivo,Utl_Raw.Cast_To_Raw(''Transaccion-1.0'')))>0 THEN ''1'' '||
                '   WHEN (dbms_lob.Instr(j.archivo,Utl_Raw.Cast_To_Raw(''NotificacionSUNAT-1.0'')))>0 THEN ''2'' ' ||
                '   WHEN (dbms_lob.Instr(j.archivo,Utl_Raw.Cast_To_Raw(''Notificacion-1.0'')))>0 THEN ''3'' '||
                '   WHEN (dbms_lob.Instr(j.archivo,Utl_Raw.Cast_To_Raw(''NotificacionAcuerdo-1.0'')))>0 THEN ''4'' '||
                '   ELSE ''0'' '||
                ' END) as SUBTIPO_XML,'||
                ' null as TIENE_INCIDENTE,'||
                ' null as TIPO_INCIDENTE,'||
                ' null as DOC_TIPO,'||
                ' null as DOC_NOM,'||
                ' null as DOC_NUM,'||
                ' null as FORMATO,'||
                ' j.archivo as ADJ_MENSAJE,'||
                ' null as ADJ_EBXML, '||
                ' a.eve_id as eve_tmp '|| -- Valor de EVE_ID en VUCE Central
                'FROM vcobj.transmision a'||
                ' inner join ( SELECT * FROM ( SELECT vc_id, adjunto_id, adjunto_tipo FROM vcobj.adjunto adj ) PIVOT ( MAX(adjunto_id) FOR adjunto_tipo in (2 mensaje, 1 ebxml)) ) b on a.vc_id = b.vc_id'||
                ' inner join vcobj.transaccion c on a.transaccion_id = c.transaccion_id '||
                ' inner join vcobj.evc d on a.evc_id = d.evc_id '||
                ' inner join vcobj.entidad e on a.entidad_id = e.entidad_id '||
                ' inner join vcobj.alerta_detalle f on a.vc_id = f.vc_id '||
                ' inner join vcobj.adjunto j on a.vc_id = j.vc_id '||
                'WHERE '||v_codigo_entidad||
                ' a.fecha_registro > to_date('''|| fecha_inicio ||''','||'''dd/mm/yy'''||') ' ||
                ' and a.fecha_registro < to_date('''|| fecha_fin ||''','||'''dd/mm/yy'''||') ' ||
                ' '||v_tipo_mensaje||
                ' '||v_vc_estado||
                ' '||v_vc_id||
                ' and j.adjunto_tipo = 2 ' ||
                
              'UNION ALL '||
              
                'select '||
                ' (CASE WHEN c.flujo_transaccion IN (1,3,5,7,10) THEN '|| 2 ||' ELSE '|| 1 || ' END) as TIPO,'||
                ' a.entidad_id as ENTIDAD_ID,'||
                ' e.siglas as ENTIDAD_SIGLAS,'||
                ' c.transaccion as MSJ_TIPO,'||
                ' c.descripcion as MSJ_NOM,'||
                ' b.mensaje as ADJ_ID_MENSAJE,'||
                ' b.ebxml as ADJ_ID_EBXML,'||
                ' f.mensaje as ERROR,'||
                ' null as VC_ID,'||
                ' a.ve_id as VE_ID,'||
                ' null as VC_ESTADO,'||
                ' a.eve_id as VE_ESTADO,'||
                ' null as VC_ESTADO_NOM,'||
                ' d.descripcion as VE_ESTADO_NOM,'||
                ' null as FECHA_REG_SALIDA,'||
                ' null as FECHA_ACT_SALIDA,'||
                ' null as ANTIG_SALIDA,'||
                ' a.fecha_registro as FECHA_REG_ENTRADA,'||
                ' a.fecha_actualizacion as FECHA_ACT_ENTRADA,'||
                ' round((sysdate-a.fecha_registro)*24*60) as ANTIG_ENTRADA,'||
                ' (CASE '||
                '   WHEN (dbms_lob.Instr(j.archivo,Utl_Raw.Cast_To_Raw(''Transaccion-1.0'')))>0 THEN ''1'' '||
                '   WHEN (dbms_lob.Instr(j.archivo,Utl_Raw.Cast_To_Raw(''NotificacionSUNAT-1.0'')))>0 THEN ''2'' ' ||
                '   WHEN (dbms_lob.Instr(j.archivo,Utl_Raw.Cast_To_Raw(''Notificacion-1.0'')))>0 THEN ''3'' '||
                '   WHEN (dbms_lob.Instr(j.archivo,Utl_Raw.Cast_To_Raw(''NotificacionAcuerdo-1.0'')))>0 THEN ''4'' '||
                '   ELSE ''0'' '||
                ' END) as SUBTIPO_XML,'||
                ' null as TIENE_INCIDENTE,'||
                ' null as TIPO_INCIDENTE,'||
                ' null as DOC_TIPO,'||
                ' null as DOC_NOM,'||
                ' null as DOC_NUM,'||
                ' null as FORMATO,'||
                ' j.archivo as ADJ_MENSAJE,'||
                ' null as ADJ_EBXML, '||
                ' null as eve_tmp '|| -- Valor de EVE_ID en VUCE Entidad
                'FROM veobj.transmision a'||
                ' inner join ( SELECT * FROM ( SELECT ve_id, adjunto_id, adjunto_tipo FROM veobj.adjunto adj ) PIVOT ( MAX(adjunto_id) FOR adjunto_tipo in (1 mensaje, 2 ebxml)) ) b on a.ve_id = b.ve_id'||
                ' inner join vcobj.transaccion c on a.transaccion_id = c.transaccion_id '||
                ' inner join vcobj.eve d on a.eve_id = d.eve_id '||
                ' inner join vcobj.entidad e on a.entidad_id = e.entidad_id '||
                ' inner join vcobj.alerta_detalle f on a.ve_id = f.ve_id '||
                ' inner join veobj.adjunto j on a.ve_id = j.ve_id '||
                'WHERE '||v_codigo_entidad||
                ' a.fecha_registro > to_date('''|| fecha_inicio ||''','||'''dd/mm/yy'''||') ' ||
                ' and a.fecha_registro < to_date('''|| fecha_fin ||''','||'''dd/mm/yy'''||') ' ||
                ' '||v_tipo_mensaje||
                ' '||v_ve_estado||
                ' '||v_ve_id||
                ' and j.adjunto_tipo = 1 '
                
            INTO v_Sql FROM dual;
            dbms_output.put_line('[LOG - filtrar_transmisiones] v_Sql: ' || v_Sql);
            
            BEGIN
              OPEN t_Cursor1 FOR v_Sql;
              LOOP
                 FETCH t_Cursor1 INTO v_tipo_tmp, v_entidad_id_tmp, v_entidad_siglas_tmp, v_mensaje_tipo_tmp, v_mensaje_nom_tmp, v_adjunto_id_mensaje_tmp, v_adjunto_id_ebxml_tmp, v_error_tmp,
                                      v_vc_id_tmp, v_ve_id_tmp, v_vc_estado_tmp, v_ve_estado_tmp, v_vc_estado_nom_tmp, v_ve_estado_nom_tmp, 
                                      v_fecha_registro_salida_tmp, v_fecha_actualiz_salida_tmp, v_antiguedad_salida_tmp, v_fecha_registro_entrada_tmp, v_fecha_actualiz_entrada_tmp, 
                                      v_antiguedad_entrada_tmp, v_subtipo_xml_tmp, v_tiene_incidente_tmp, v_tipo_incidente_tmp, v_documento_tipo_tmp, v_documento_nom_tmp, v_documento_num_tmp, 
                                      v_formato_tmp, v_adjunto_mensaje_tmp, v_adjunto_ebxml_tmp, v_eve_estadotmp_tmp;
				 /*IF v_vc_id_tmp IS NULL THEN
				 	CONTINUE;
				 END IF;*/
                 EXIT WHEN t_Cursor1%NOTFOUND;
                 
                 ------------------------------------------------------------------------------------------
                 -- INI - Validacion de datos del Documento: Tipo, Nombre, Número
                 ------------------------------------------------------------------------------------------
                 --dbms_output.put_line('v_tipo_tmp =' || v_tipo_tmp);
                 IF v_tipo_tmp = 2 THEN
                    CASE 
                      WHEN (v_subtipo_xml_tmp = 1) THEN 
                        v_documento_tipo_tmp := XMLTYPE(REPLACE(UTL_RAW.cast_to_varchar2(v_adjunto_mensaje_tmp),'xmlns="Transaccion-1.0"','')).extract('/transaccion/documento/tipo/text()').getStringVal();
                        v_documento_num_tmp := XMLTYPE(REPLACE(UTL_RAW.cast_to_varchar2(v_adjunto_mensaje_tmp),'xmlns="Transaccion-1.0"','')).extract('/transaccion/documento/numero/text()').getStringVal();
                      WHEN (v_subtipo_xml_tmp = 2) THEN 
                        v_documento_tipo_tmp := XMLTYPE(REPLACE(UTL_RAW.cast_to_varchar2(v_adjunto_mensaje_tmp),'xmlns="NotificacionSUNAT-1.0"','')).extract('/transaccion/documento/tipo/text()').getStringVal();
                        v_documento_num_tmp := XMLTYPE(REPLACE(UTL_RAW.cast_to_varchar2(v_adjunto_mensaje_tmp),'xmlns="NotificacionSUNAT-1.0"','')).extract('/transaccion/documento/numero/text()').getStringVal();
                      WHEN (v_subtipo_xml_tmp = 3) THEN 
                        v_documento_tipo_tmp := XMLTYPE(REPLACE(UTL_RAW.cast_to_varchar2(v_adjunto_mensaje_tmp),'xmlns="Notificacion-1.0"','')).extract('/notificacion/documento/tipo/text()').getStringVal();
                        v_documento_num_tmp := XMLTYPE(REPLACE(UTL_RAW.cast_to_varchar2(v_adjunto_mensaje_tmp),'xmlns="Notificacion-1.0"','')).extract('/notificacion/documento/numero/text()').getStringVal();
                      WHEN (v_subtipo_xml_tmp = 4) THEN 
                        v_documento_tipo_tmp := XMLTYPE(REPLACE(UTL_RAW.cast_to_varchar2(v_adjunto_mensaje_tmp),'xmlns="NotificacionAcuerdo-1.0"','')).extract('/notificacionAcuerdo/documento/tipo/text()').getStringVal();
                        v_documento_num_tmp := XMLTYPE(REPLACE(UTL_RAW.cast_to_varchar2(v_adjunto_mensaje_tmp),'xmlns="NotificacionAcuerdo-1.0"','')).extract('/notificacionAcuerdo/documento/numero/text()').getStringVal();
                      ELSE
                        v_documento_tipo_tmp := '0';
                        v_documento_num_tmp := 'NO APLICA';
                   END CASE;
                   
                   CASE
                      WHEN (v_documento_tipo_tmp = 'O') THEN v_documento_nom_tmp := 'Orden';
                      WHEN (v_documento_tipo_tmp = 'MTO') THEN v_documento_nom_tmp := 'Modificación Temporal de la Orden';
                      WHEN (v_documento_tipo_tmp = 'S') THEN v_documento_nom_tmp := 'SUCE';
                      WHEN (v_documento_tipo_tmp = 'DR') THEN v_documento_nom_tmp := 'Documento Resolutivo';
                      WHEN (v_documento_tipo_tmp = 'CDA') THEN v_documento_nom_tmp := 'CDA';
                      WHEN (v_documento_tipo_tmp = 'T') THEN v_documento_nom_tmp := 'Ticket Notificación';
                      WHEN (v_documento_tipo_tmp = 'E') THEN v_documento_nom_tmp := 'Expediente';
                      WHEN (v_documento_tipo_tmp = 'CT') THEN v_documento_nom_tmp := 'Consulta Técnica';
                      WHEN (v_documento_tipo_tmp = 'MOS') THEN v_documento_nom_tmp := 'MOS';
                      ELSE v_documento_nom_tmp := 'NO APLICA';
                   END CASE;
                 END IF;
                 ------------------------------------------------------------------------------------------
                 -- FIN - Validacion de datos del Documento
                 ------------------------------------------------------------------------------------------
                 
                 ------------------------------------------------------------------------------------------
                 -- INI - Validacion de Incidentes: tiene incidente, tipo incidente --> v_vc_id_temporal_tmp, v_ve_id_temporal_tmp
                 ------------------------------------------------------------------------------------------
                 v_tipo_incidente_tmp := null;
                 CASE 
                    WHEN (v_tipo_tmp = 1) THEN 
                      -- Codigo 3
                      IF v_ve_estado_tmp = 11 THEN
                        v_tipo_incidente_tmp := 3;
                      END IF;
                      -- Codigo 4
                      IF (v_ve_estado_tmp = 5) THEN
                        v_sla_valor_tmp := mtsrc.proyecto_bus.obtener_sla_por_entidad (pentidad_id => v_entidad_id_tmp,
                                                                                   psla_nombre => 'SLA_PROCESAMIENTO_TRAN_ENTRADA');
                        IF ROUND((sysdate - v_fecha_registro_entrada_tmp)*24*60)>v_sla_valor_tmp THEN
                          v_tipo_incidente_tmp := 4;
                        END IF;
                      END IF;
                    WHEN (v_tipo_tmp = 2) THEN 
                      -- Codigo 2
                      --IF v_ve_estado_tmp = 12 THEN
                      IF v_eve_estadotmp_tmp = 12 THEN
                        v_tipo_incidente_tmp := 2;
                      END IF;
                      -- Codigo 1
                      --IF (v_ve_estado_tmp = 2) THEN
                      IF (v_eve_estadotmp_tmp = 2) THEN
                        v_sla_valor_tmp := mtsrc.proyecto_bus.obtener_sla_por_entidad (pentidad_id => v_entidad_id_tmp,
                                                                                   psla_nombre => 'SLA_CONFIRMACION_TRAN_SALIDA');
                        IF ROUND((sysdate - v_fecha_registro_salida_tmp)*24*60)>v_sla_valor_tmp THEN
                          v_tipo_incidente_tmp := 1;
                        END IF;
                      END IF;
                      -- Codigo 5
                      IF (v_vc_estado_tmp = 1 OR  v_vc_estado_tmp = 14) THEN
                        v_sla_valor_tmp := mtsrc.proyecto_bus.obtener_sla_por_entidad (pentidad_id => v_entidad_id_tmp,
                                                                                   psla_nombre => 'SLA_DISPONIBILIDAD_TRAN_SALIDA');
                        IF ROUND((sysdate - v_fecha_registro_salida_tmp)*24*60)>v_sla_valor_tmp THEN
                          v_tipo_incidente_tmp := 5;
                        END IF;
                      END IF;
                    ELSE
                      v_tipo_incidente_tmp := null;
                 END CASE;
                 
                 IF v_tipo_incidente_tmp is NOT NULL THEN
                    v_tiene_incidente_tmp := 1;
                 END IF;
                 ------------------------------------------------------------------------------------------
                 -- FIN - Validacion de Incidentes
                 ------------------------------------------------------------------------------------------
                 
                 ------------------------------------------------------------------------------------------
                 -- INI - Validacion del FORMATO
                 -- Depende del valor de MENSAJE_TIPO. Ejm: N1, N2, N14, ...
                 ------------------------------------------------------------------------------------------
                 -- Si es de SALIDA
                 IF v_tipo_tmp = 2 THEN
                    CASE
                      WHEN (v_mensaje_tipo_tmp = 'N44') THEN 
                        -- N44  Envio de archivo de Liquidacion de Pagos, corresponde a varios formatos, por ello NO APLICA
                        v_formato_tmp := 'NO APLICA';
                      WHEN (v_mensaje_tipo_tmp in ('N1','N2','N3','N4','N5','N6','N7','N8','N9','N11','N14','N17','N18','N22','N27','N30','N33','N40','N44','N54','N57','N66','N68','N76','N83','N85')) THEN 
					  dbms_output.put_line('v_vc_id_tmp '||v_vc_id_tmp);
					  dbms_output.put_line('v_mensaje_tipo_tmp '||v_mensaje_tipo_tmp);
                        select d.formato 
                          INTO v_formato_tmp
                        from vcobj.transmision a, vcobj.tce_transmision b, vcobj.tce c, vcobj.formato d
                        where a.vc_id = b.vc_id 
                          and b.tce_id = c.tce_id
                          and c.formato_id = d.formato_id
                          and a.vc_id = v_vc_id_tmp;
                      ELSE
                        v_formato_tmp := 'NO APLICA';
                    END CASE;
                 END IF;
                 ------------------------------------------------------------------------------------------
                 -- FIN - Validacion del FORMATO
                 ------------------------------------------------------------------------------------------
                 
                 ------------------------------------------------------------------------------------------
                 -- INI - Asignar el EBXML
                 ------------------------------------------------------------------------------------------
                 -- Dependiendo si es vc o ve, se obtiene el archivo adjunto ebxml
                 IF (v_vc_id_tmp is NOT NULL AND v_adjunto_id_ebxml_tmp is NOT NULL) THEN
                    select a.archivo 
                        into v_adjunto_ebxml_tmp
                        from vcobj.adjunto a
                        where a.vc_id = v_vc_id_tmp 
                          and a.adjunto_id = v_adjunto_id_ebxml_tmp;
                 END IF;
                 IF (v_ve_id_tmp is NOT NULL AND v_adjunto_id_ebxml_tmp is NOT NULL) THEN
                    select a.archivo 
                        into v_adjunto_ebxml_tmp
                        from veobj.adjunto a
                        where a.ve_id = v_ve_id_tmp 
                          and a.adjunto_id = v_adjunto_id_ebxml_tmp;
                 END IF;
                 ------------------------------------------------------------------------------------------
                 -- FIN - Asignar el EBXML
                 ------------------------------------------------------------------------------------------
                 
                 ------------------------------------------------------------------------------------------
                 -- INI - Insertar datos en la tabla temporal: MTOBJ.MONITOREO_INCIDENTES_TMP
                 ------------------------------------------------------------------------------------------
                 INSERT INTO MTOBJ.MONITOREO_INCIDENTES_TMP VALUES (v_tipo_tmp, v_entidad_id_tmp, v_entidad_siglas_tmp, v_mensaje_tipo_tmp, v_mensaje_nom_tmp, v_adjunto_id_mensaje_tmp, v_adjunto_id_ebxml_tmp, v_error_tmp, v_vc_id_tmp, v_ve_id_tmp, v_vc_estado_tmp, v_ve_estado_tmp, 
                                      v_vc_estado_nom_tmp, v_ve_estado_nom_tmp, v_fecha_registro_salida_tmp, v_fecha_actualiz_salida_tmp, v_antiguedad_salida_tmp, v_fecha_registro_entrada_tmp, v_fecha_actualiz_entrada_tmp, 
                                      v_antiguedad_entrada_tmp, v_subtipo_xml_tmp, v_tiene_incidente_tmp, v_tipo_incidente_tmp, v_documento_tipo_tmp, v_documento_nom_tmp, v_documento_num_tmp, v_formato_tmp, v_adjunto_mensaje_tmp, v_adjunto_ebxml_tmp);
                 ------------------------------------------------------------------------------------------
                 -- FIN - Insertar datos
                 ------------------------------------------------------------------------------------------
              END LOOP;
              CLOSE t_Cursor1;
            END;

        
        --Validacion de parámetros
        CASE
          WHEN (tipo_transmision = 1) THEN  -- No se realizan validaciones            
            v_tipo_transmision := ' 1=1 ';
          WHEN (tipo_transmision = 2) THEN  -- Con incidentes
            v_tipo_transmision := ' a.tiene_incidente = 1 ';
          WHEN (tipo_transmision = 3) THEN  -- Sin incidentes
            v_tipo_transmision := ' a.tiene_incidente = 2 ';
          ELSE
            v_tipo_transmision := ' 1=1 '; -- No se realizan validaciones  
        END CASE;
        
        v_Sql2 := 'SELECT '||
                  '    a.tipo, a.tiene_incidente, a.tipo_incidente,'||
                  '    a.entidad_id, a.entidad_siglas,'||
                  '    a.mensaje_tipo, a.mensaje_nom,'||
                  '    a.adjunto_mensaje, a.adjunto_ebxml,'||
                  '    a.error,'||
                  '    a.vc_id, a.ve_id, a.vc_estado, a.vc_estado_nom, a.ve_estado, a.ve_estado_nom,'||
                  '    a.documento_tipo, a.documento_nom, a.documento_num,'||
                  '    a.fecha_registro_salida, a.fecha_actualizacion_salida, a.antiguedad_salida, a.formato,'||
                  '    a.fecha_registro_entrada, a.fecha_actualizacion_entrada, a.antiguedad_entrada'||
                  ' FROM mtobj.monitoreo_incidentes_tmp a '||
                  ' WHERE '||v_tipo_transmision||
                  '  '||v_tipo_incidente||
                  '  '||v_tipo_documento||
                  '  '||v_numero_documento;
         dbms_output.put_line('[LOG - filtrar_transmisiones] v_Sql2: ' || v_Sql2);
         
        OPEN t_Cursor2 FOR v_Sql2;
        filtrar_transmisiones.tCursor := t_Cursor2;
    END filtrar_transmisiones;
  
  /* **************************************************************
  FUNCTION obtener_tx_con_incidente         ------------------------------------------> PENDIENTE!!!!
      La función devuelve en un CURSOR, las transmisiones, ordenadas por las siglas de la entidad, que cumplen con la condición siguiente:
      - Fecha de creación es igual o mayor al parámetro 1
      - Fecha de creación es igual o menor al parámetro 2 
  *****************************************************************/
  PROCEDURE obtener_tx_con_incidentes (
    fecha_inicio IN DATE,
    fecha_fin   IN DATE,
    tCursor             OUT cur_Tabla   -- Cursor de salida
  )
  IS    
    t_Cursor1          cur_Tabla;
    t_Cursor2          cur_Tabla;
    numRows           NUMBER;
    v_codigo_entidad  VARCHAR2(50);
    v_codigo_mensaje  VARCHAR2(50);
    v_tipo_mensaje    VARCHAR2(100);
    v_tipo_documento    VARCHAR2(50);
    v_numero_documento    VARCHAR2(50);
    v_tipo_transmision  VARCHAR2(50);
    v_tipo_incidente    VARCHAR2(50);
    v_vc_id    VARCHAR2(50);
    v_ve_id    VARCHAR2(50);
    v_vc_estado    VARCHAR2(50);
    v_ve_estado    VARCHAR2(50);
  
    v_tipo_tmp   NUMBER(1,0);
    v_entidad_id_tmp VARCHAR2(10); 
    v_entidad_siglas_tmp VARCHAR2(50);
    v_mensaje_tipo_tmp VARCHAR2(5);
    v_vc_id_tmp NUMBER(10,0); 
    v_ve_id_tmp NUMBER(10,0);  
    v_vc_estado_tmp NUMBER(2,0); 
    v_ve_estado_tmp NUMBER(2,0); 
    v_vc_estado_nom_tmp VARCHAR2(100 byte);
    v_ve_estado_nom_tmp VARCHAR2(100 byte);
    v_fecha_registro_salida_tmp DATE;
    v_fecha_registro_entrada_tmp DATE;
    v_tipo_incidente_tmp NUMBER(1,0);
    v_eve_estadotmp_tmp  NUMBER(2,0);     
    v_sla_valor_tmp NUMBER(5,0);
        v_Sql             CLOB;
        v_Sql2            CLOB;
    v_param_max_dias  NUMBER(2,0);
    
  BEGIN
  
      -- QUERY para crear la tabla temporal con los datos de iniciales de consulta
        SELECT 'select '||
                ' (CASE WHEN c.flujo_transaccion IN (1,3,5,7,10) THEN '|| 2 ||' ELSE '|| 1 || ' END) as TIPO,'||
                ' a.entidad_id as ENTIDAD_ID,'||
                ' e.siglas as ENTIDAD_SIGLAS,'||
                ' c.transaccion as MSJ_TIPO,'||
                ' a.vc_id as VC_ID,'||
                ' null as VE_ID,'||
                ' a.evc_id as VC_ESTADO,'||
                ' null as VE_ESTADO,'||
                ' d.descripcion as VC_ESTADO_NOM,'||
                ' null as VE_ESTADO_NOM,'||
                ' a.fecha_registro as FECHA_REG_SALIDA,'||
                ' null as FECHA_REG_ENTRADA,'||
                ' null as TIPO_INCIDENTE,'||
                ' a.eve_id as eve_tmp '|| -- Valor de EVE_ID en VUCE Central
                'FROM vcobj.transmision a'||
                ' inner join vcobj.transaccion c on a.transaccion_id = c.transaccion_id '||
                ' inner join vcobj.evc d on a.evc_id = d.evc_id '||
                ' inner join vcobj.entidad e on a.entidad_id = e.entidad_id '||
                'WHERE '||
                ' a.fecha_registro > to_date('''|| fecha_inicio ||''','||'''dd/mm/yy'''||') ' ||
                ' and a.fecha_registro < to_date('''|| fecha_fin ||''','||'''dd/mm/yy'''||') ' ||
                ' and ( a.evc_id in (1, 14) or a.eve_id in (2, 12, 11, 5) ) ' ||
                
              'UNION ALL '||
              
                'select '||
                ' (CASE WHEN c.flujo_transaccion IN (1,3,5,7,10) THEN '|| 2 ||' ELSE '|| 1 || ' END) as TIPO,'||
                ' a.entidad_id as ENTIDAD_ID,'||
                ' e.siglas as ENTIDAD_SIGLAS,'||
                ' c.transaccion as MSJ_TIPO,'||
                ' null as VC_ID,'||
                ' a.ve_id as VE_ID,'||
                ' null as VC_ESTADO,'||
                ' a.eve_id as VE_ESTADO,'||
                ' null as VC_ESTADO_NOM,'||
                ' d.descripcion as VE_ESTADO_NOM,'||
                ' null as FECHA_REG_SALIDA,'||
                ' a.fecha_registro as FECHA_REG_ENTRADA,'||
                ' null as TIPO_INCIDENTE,'||
                ' null as eve_tmp '|| -- Valor de EVE_ID en VUCE Entidad
                'FROM veobj.transmision a'||
                ' inner join vcobj.transaccion c on a.transaccion_id = c.transaccion_id '||
                ' inner join vcobj.eve d on a.eve_id = d.eve_id '||
                ' inner join vcobj.entidad e on a.entidad_id = e.entidad_id '||
                'WHERE '||
                ' a.fecha_registro > to_date('''|| fecha_inicio ||''','||'''dd/mm/yy'''||') ' ||
                ' and a.fecha_registro < to_date('''|| fecha_fin ||''','||'''dd/mm/yy'''||') ' ||
                ' and a.eve_id in (2, 12, 11, 5) '
                
            INTO v_Sql FROM dual;
            dbms_output.put_line('[LOG - obtener_tx_con_incidentes] v_Sql: ' || v_Sql);
           
           BEGIN
              OPEN t_Cursor1 FOR v_Sql;
              LOOP
                 FETCH t_Cursor1 INTO v_tipo_tmp, v_entidad_id_tmp, v_entidad_siglas_tmp, v_mensaje_tipo_tmp,
                                      v_vc_id_tmp, v_ve_id_tmp, v_vc_estado_tmp, v_ve_estado_tmp, v_vc_estado_nom_tmp, v_ve_estado_nom_tmp, 
                                      v_fecha_registro_salida_tmp, v_fecha_registro_entrada_tmp, v_tipo_incidente_tmp, v_eve_estadotmp_tmp;
                 EXIT WHEN t_Cursor1%NOTFOUND;
                 
                 ------------------------------------------------------------------------------------------
                 -- INI - Validacion de Incidentes: tiene incidente, tipo incidente --> v_vc_id_temporal_tmp, v_ve_id_temporal_tmp
                 ------------------------------------------------------------------------------------------
                 v_tipo_incidente_tmp := 0;
                 CASE 
                    WHEN (v_tipo_tmp = 1) THEN 
                      -- Codigo 3
                      IF v_ve_estado_tmp = 11 THEN
                        v_tipo_incidente_tmp := 3;
                      END IF;
                      -- Codigo 4
                      IF (v_ve_estado_tmp = 5) THEN
                        v_sla_valor_tmp := mtsrc.proyecto_bus.obtener_sla_por_entidad (pentidad_id => v_entidad_id_tmp,
                                                                                   psla_nombre => 'SLA_PROCESAMIENTO_TRAN_ENTRADA');
                        IF ROUND((sysdate - v_fecha_registro_entrada_tmp)*24*60)>v_sla_valor_tmp THEN
                          v_tipo_incidente_tmp := 4;
                        END IF;
                      END IF;
                    WHEN (v_tipo_tmp = 2) THEN 
                      -- Codigo 2
                      --IF v_ve_estado_tmp = 12 THEN
                      IF v_eve_estadotmp_tmp = 12 THEN
                        v_tipo_incidente_tmp := 2;
                      END IF;
                      -- Codigo 1
                      --IF (v_ve_estado_tmp = 2) THEN
                      IF (v_eve_estadotmp_tmp = 2) THEN
                        v_sla_valor_tmp := mtsrc.proyecto_bus.obtener_sla_por_entidad (pentidad_id => v_entidad_id_tmp,
                                                                                   psla_nombre => 'SLA_CONFIRMACION_TRAN_SALIDA');
                        IF ROUND((sysdate - v_fecha_registro_salida_tmp)*24*60)>v_sla_valor_tmp THEN
                          v_tipo_incidente_tmp := 1;
                        END IF;
                      END IF;
                      -- Codigo 5
                      IF (v_vc_estado_tmp = 1 OR  v_vc_estado_tmp = 14) THEN
                        v_sla_valor_tmp := mtsrc.proyecto_bus.obtener_sla_por_entidad (pentidad_id => v_entidad_id_tmp,
                                                                                   psla_nombre => 'SLA_DISPONIBILIDAD_TRAN_SALIDA');
                        IF ROUND((sysdate - v_fecha_registro_salida_tmp)*24*60)>v_sla_valor_tmp THEN
                          v_tipo_incidente_tmp := 5;
                        END IF;
                      END IF;
                    ELSE
                      v_tipo_incidente_tmp := 0;    -- Si no entra a ningún caso entonces por defecto es CERO = 0
                 END CASE;
                 
                 ------------------------------------------------------------------------------------------
                 -- FIN - Validacion de Incidentes
                 ------------------------------------------------------------------------------------------
                                  
                 ------------------------------------------------------------------------------------------
                 -- INI - Insertar datos en la tabla temporal: MTOBJ.MONITOREO_INCIDENTES_TMP
                 ------------------------------------------------------------------------------------------
                 INSERT INTO MTOBJ.MONITOREO_INCIDENTES_CONT_TMP VALUES (v_tipo_tmp, v_entidad_id_tmp, v_entidad_siglas_tmp, v_mensaje_tipo_tmp, v_vc_id_tmp, v_ve_id_tmp, v_vc_estado_tmp, v_ve_estado_tmp, 
                                                                          v_vc_estado_nom_tmp, v_ve_estado_nom_tmp, v_fecha_registro_salida_tmp, v_fecha_registro_entrada_tmp, v_tipo_incidente_tmp );
                 ------------------------------------------------------------------------------------------
                 -- FIN - Insertar datos
                 ------------------------------------------------------------------------------------------                
              END LOOP;
              CLOSE t_Cursor1;
            END;
            
        -- Cursor para el listado de entidades con transmisiones con ERROR
        v_Sql2 := 'SELECT * FROM ( '||
                       ' SELECT entidad_id, entidad_siglas, tipo '||
                       ' FROM mtobj.monitoreo_incidentes_cont_tmp '||
                       ' where tipo_incidente <> 0 )'||
                       ' PIVOT '||
                       ' ( COUNT(tipo) FOR tipo in (1 transmisiones_entrada, 2 transmisiones_salida)) ';
        dbms_output.put_line('[LOG - obtener_tx_con_incidentes] v_Sql2: ' || v_Sql2); 
         
        OPEN t_Cursor2 FOR v_Sql2;
        obtener_tx_con_incidentes.tCursor := t_Cursor2;
        
  END obtener_tx_con_incidentes;
  
 /* **************************************************************
  PROCEDURE reenviar_tx_salida_con_error         ------------------------------------------> PENDIENTE!!!!
      Actualiza el estado de la transmisión para que pueda volver a ser leída por la entidad 
  *****************************************************************/  
  PROCEDURE reenviar_tx_salida_con_error  (
        vc_id_in                    IN  NUMBER,
    vc_transaccion  IN  VARCHAR2,
        ve_id_in                    IN  NUMBER,
    ve_transaccion  IN  VARCHAR2,
        resultado_valor     OUT NUMBER,
        resultado_mensaje   OUT VARCHAR2
        )
  IS
      v_evc_estado_tmp   NUMBER;
      v_eve_estado_tmp   NUMBER;
      v_resultado_valor   NUMBER;
      v_resultado_mensaje   VARCHAR2(200);
    BEGIN
    
    dbms_output.put_line('[LOG - reenviar_tx_salida_con_error]');
        -- Se valida la transacción - N. Solo aquellas transmisiones de Salida.
    -- Considerar que para reenviar_tx_salida_con_error, se debe enviar VC o VE, pero no ambos
    
    -- Validamos el Parametro VC_ID
    IF vc_id_in <> null THEN
      CASE 
        WHEN vc_transaccion in ('N1', 'N3', 'N4', 'N6', 'N10', 'N12', 'N14', 'N18', 'N23', 'N24', 'N26', 'N28', 'N30', 'N31', 'N32', 
                                  'N33', 'N34', 'N38', 'N40', 'N41', 'N42', 'N43', 'N44', 'N45', 'N50', 'N51', 'N52', 'N53', 'N54', 
                                  'N55', 'N59', 'N60', 'N61', 'N62', 'N70', 'N71', 'N76', 'N85', 'N86', 'N87', 'N93' ) THEN 
          v_resultado_valor := 0;
        ELSE
          v_resultado_valor := 1;
          v_resultado_mensaje := mtsrc.proyecto_bus.resultado_mensaje_texto(vc_id_in, v_resultado_valor, 'anular', vc_transaccion || ' - No es una transmision de Salida');
      END CASE;
    END IF;
    
    -- Validamos el Parametro VE_ID
    IF ve_id_in <> null THEN
      CASE 
        WHEN ve_transaccion in ('N1', 'N3', 'N4', 'N6', 'N10', 'N12', 'N14', 'N18', 'N23', 'N24', 'N26', 'N28', 'N30', 'N31', 'N32', 
                                  'N33', 'N34', 'N38', 'N40', 'N41', 'N42', 'N43', 'N44', 'N45', 'N50', 'N51', 'N52', 'N53', 'N54', 
                                  'N55', 'N59', 'N60', 'N61', 'N62', 'N70', 'N71', 'N76', 'N85', 'N86', 'N87', 'N93' ) THEN 
          v_resultado_valor := 0;
        ELSE
          v_resultado_valor := 1;
          v_resultado_mensaje := mtsrc.proyecto_bus.resultado_mensaje_texto(ve_id_in, v_resultado_valor, 'anular', ve_transaccion || ' - No es una transmision de Salida');
      END CASE;
    END IF;
    
    IF v_resultado_valor = 0 THEN
    
      -- Parametro VC_ID
      IF vc_id_in <> null THEN
        -- Obtenemos el estado del registro ve_id
        select t.evc_id 
            into v_evc_estado_tmp
          from vcobj.transmision t 
          where t.vc_id = vc_id_in;
        -- Validación del estado EVE_ID
        IF v_evc_estado_tmp = 14 THEN -- ESTADO = 14 - TRANSMISION ANULADA
            update vcobj.transmision t set t.evc_id = 1 where t.vc_id = vc_id_in; -- Actualizar a ESTADO = 1 - POR ENVIAR A E
            v_resultado_valor := 0;
            v_resultado_mensaje := mtsrc.proyecto_bus.resultado_mensaje_texto (vc_id_in, v_resultado_valor, 'reenviar', ' ');
          ELSE 
            v_resultado_valor := 1;
            v_resultado_mensaje := mtsrc.proyecto_bus.resultado_mensaje_texto (vc_id_in, v_resultado_valor, 'reenviar', 'No es una transmisión para Reenviar (no tiene estado 12)');
          END IF;
      END IF;
    
      -- Parametro VE_ID
      IF ve_id_in <> null THEN
        -- Obtenemos el estado del registro ve_id
        select t.eve_id 
            into v_eve_estado_tmp
          from veobj.transmision t 
          where t.ve_id = ve_id_in;
        -- Validación del estado EVE_ID
        IF v_eve_estado_tmp = 12 THEN -- ESTADO = 12 - PROCESADO CON ERRORES EN ENTIDAD
            update veobj.transmision t set t.eve_id = 1 where t.ve_id = ve_id_in; -- Actualizar a ESTADO = 1 - POR ENVIAR A E
            v_resultado_valor := 0;
            v_resultado_mensaje := mtsrc.proyecto_bus.resultado_mensaje_texto (ve_id_in, v_resultado_valor, 'reenviar', ' ');
          ELSE 
            v_resultado_valor := 1;
            v_resultado_mensaje := mtsrc.proyecto_bus.resultado_mensaje_texto (ve_id_in, v_resultado_valor, 'reenviar', 'No es una transmisión para Reenviar (no tiene estado 12)');
          END IF;
      END IF;
    END IF;
    
    dbms_output.put_line('v_resultado_mensaje: '||v_resultado_mensaje);
    reenviar_tx_salida_con_error.resultado_valor := v_resultado_valor;
    reenviar_tx_salida_con_error.resultado_mensaje := v_resultado_mensaje;
    
    END reenviar_tx_salida_con_error;   
  
  /* **************************************************************
  PROCEDURE reproc_tx_entrada_con_error         ------------------------------------------> PENDIENTE!!!!
      Actualiza el estado de la transmisión para que pueda ser reprocesada.
  *****************************************************************/  
  PROCEDURE  reproc_tx_entrada_con_error (
        vc_id_in            IN  NUMBER,
    vc_transaccion  IN  VARCHAR2,
        ve_id_in            IN  NUMBER,
    ve_transaccion  IN  VARCHAR2,
        resultado_valor     OUT NUMBER,
        resultado_mensaje   OUT VARCHAR2
        )
  IS
      v_eve_estado_tmp    NUMBER;
      v_eve_estado_ini_tmp    NUMBER;
      v_resultado_valor   NUMBER;
      v_resultado_mensaje   VARCHAR2(200);
    BEGIN
    
    dbms_output.put_line('[LOG - reproc_tx_entrada_con_error]');
    CASE 
      WHEN ve_transaccion in ('N2', 'N5', 'N7', 'N8', 'N9', 'N11', 'N13', 'N15', 'N16', 'N17', 'N19', 'N20', 'N21', 'N22', 
                                'N25', 'N27', 'N29', 'N35', 'N36', 'N37', 'N39', 'N46', 'N47', 'N48', 'N49', 'N56', 'N57', 
                                'N63', 'N64', 'N65', 'N66', 'N67', 'N68', 'N69', 'N88', 'N89', 'N90', 'N91', 'N92') THEN 
        v_resultado_valor := 0;
      ELSE
        v_resultado_valor := 1;
        v_resultado_mensaje := mtsrc.proyecto_bus.resultado_mensaje_texto(ve_id_in, v_resultado_valor, 'reprocesar', ve_transaccion || ' - No es una transmision de Entrada');
    END CASE;
    
    IF v_resultado_valor = 0 THEN
      -- Dependiendo del N, se realiza la actualización de datos
      
      CASE 
        WHEN ve_transaccion in ('N2', 'N7', 'N8', 'N9', 'N11', 'N15', 'N17', 'N19', 'N20', 'N21', 'N22', 'N27', 'N35', 
                                  'N36', 'N37', 'N39', 'N48', 'N49', 'N57', 'N66', 'N67', 'N68', 'N88', 'N89', 'N90', 'N91', 'N92') THEN 
          v_eve_estado_tmp := 5;
          v_eve_estado_ini_tmp := 11;
        WHEN ve_transaccion in ('N5', 'N13', 'N16', 'N25', 'N29', 'N46', 'N47', 'N56', 'N63', 'N64', 'N65', 'N69') THEN 
          v_eve_estado_tmp := 0;
          v_eve_estado_ini_tmp := 0;
        ELSE
          v_eve_estado_tmp := 0;
          v_eve_estado_ini_tmp := 0;
      END CASE;
      
      -- Actualizar el estado de la transmision
      update veobj.transmision 
        set eve_id = v_eve_estado_tmp
        where ve_id = ve_id_in
          and eve_id = v_eve_estado_ini_tmp;
      
      IF sql%rowcount = 0 THEN
        v_resultado_valor := 1;
        v_resultado_mensaje := mtsrc.proyecto_bus.resultado_mensaje_texto (ve_id_in, v_resultado_valor, 'reprocesar', 'No es una transmisión para reprocesar.');
      ELSE 
        v_resultado_valor := 0;
        v_resultado_mensaje := mtsrc.proyecto_bus.resultado_mensaje_texto (ve_id_in, v_resultado_valor, 'reprocesar', ' ');
      END IF;

    END IF;
    dbms_output.put_line('v_resultado_mensaje: '||v_resultado_mensaje);

    reproc_tx_entrada_con_error.resultado_valor := v_resultado_valor;
    reproc_tx_entrada_con_error.resultado_mensaje := v_resultado_mensaje;
    END reproc_tx_entrada_con_error;
  
  /* **************************************************************
  PROCEDURE reproc_tx_entrada_n8_con_error         ------------------------------------------> PENDIENTE!!!!
      Actualiza el estado de la transmisión para que pueda ser reprocesada para N8.
  *****************************************************************/  
  PROCEDURE  reproc_tx_entrada_n8_con_error (
    entidad_id_in           IN  NUMBER,
        fecha_inicio          IN    DATE,
        fecha_fin               IN  DATE,
        resultado_valor     OUT NUMBER,
        resultado_mensaje   OUT VARCHAR2
        )
  IS
      v_resultado_valor   NUMBER;
    v_resultado_mensaje   VARCHAR2(200);
    BEGIN
    
    dbms_output.put_line('[LOG - reproc_tx_entrada_n8_con_error]');
    
        IF entidad_id_in is not null THEN
      --  11 - PROCESADO CON ERRORES EN VC
      --  5 - POR ENVIAR A VC
      update veobj.transmision 
        set eve_id = 5
        where entidad_id = entidad_id_in
          and eve_id = 11
          and fecha_registro > fecha_inicio
          and fecha_registro < fecha_fin;
      
      IF sql%rowcount = 0 THEN
        v_resultado_valor := 1;
        v_resultado_mensaje := 'La solicitud de reprocesamiento de las transmisiones presenta errores.';
      ELSE 
        v_resultado_valor := 0;
        v_resultado_mensaje := 'La solicitud de reprocesamiento de las transmisiones fue ingresada correctamente';
      END IF;
    END IF;
    
    dbms_output.put_line('[LOG - reproc_tx_entrada_n8_con_error - v_resultado_mensaje]: '||v_resultado_mensaje);
    reproc_tx_entrada_n8_con_error.resultado_valor := v_resultado_valor;
    reproc_tx_entrada_n8_con_error.resultado_mensaje := v_resultado_mensaje;
        
    END reproc_tx_entrada_n8_con_error;
  
  /* **************************************************************
  PROCEDURE anular_tx_entrada_con_error
      Actualiza el estado de la transmisión para que deje de ser considerada como una transmisión (o sea es anulada).
  *****************************************************************/  
  PROCEDURE anular_tx_entrada_con_error  (
        vc_id_in                    IN  NUMBER,
    vc_transaccion      IN VARCHAR2,
        ve_id_in                   IN   NUMBER,
    ve_transaccion      IN VARCHAR2,
        resultado_valor      OUT NUMBER,
        resultado_mensaje    OUT VARCHAR2
        )
  IS
      v_eve_estado_tmp   NUMBER;
      v_resultado_valor   NUMBER;
      v_resultado_mensaje   VARCHAR2(200);
    BEGIN
    -- Considerar que para anular_tx_entrada_con_error, solo se valida el valor de VE
    dbms_output.put_line('[LOG - anular_tx_entrada_con_error]');
    
    CASE 
      WHEN ve_transaccion in ('N2', 'N5', 'N7', 'N8', 'N9', 'N11', 'N13', 'N15', 'N16', 'N17', 'N19', 'N20', 'N21', 'N22', 
                                'N25', 'N27', 'N29', 'N35', 'N36', 'N37', 'N39', 'N46', 'N47', 'N48', 'N49', 'N56', 'N57', 
                                'N63', 'N64', 'N65', 'N66', 'N67', 'N68', 'N69', 'N88', 'N89', 'N90', 'N91', 'N92') THEN 
        v_resultado_valor := 0;
      ELSE
        v_resultado_valor := 1;
        v_resultado_mensaje := mtsrc.proyecto_bus.resultado_mensaje_texto(ve_id_in, v_resultado_valor, 'anular', ve_transaccion || ' - No es una transmision de Entrada');
    END CASE;
    
    IF v_resultado_valor = 0 THEN
      -- Obtenemos el estado del registro ve_id
      select t.eve_id 
          into v_eve_estado_tmp
        from veobj.transmision t 
        where t.ve_id = ve_id_in;
      -- Validación del estado EVE_ID
      IF v_eve_estado_tmp = 11 THEN -- ESTADO = 11 - PROCESADO CON ERRORES EN VC
          update veobj.transmision t set t.eve_id = 14 where t.ve_id = ve_id_in; -- Actualizar a ESTADO = 14 - TRANSMISION ANULADA
          v_resultado_valor := 0;
          v_resultado_mensaje := mtsrc.proyecto_bus.resultado_mensaje_texto (ve_id_in, v_resultado_valor, 'anular', ' ');
        ELSE 
          v_resultado_valor := 1;
          v_resultado_mensaje := mtsrc.proyecto_bus.resultado_mensaje_texto (ve_id_in, v_resultado_valor, 'anular', 'No es una transmisión para Anular (no tiene estado 11)');
        END IF;
    END IF;
    dbms_output.put_line('v_resultado_mensaje: '||v_resultado_mensaje);

    anular_tx_entrada_con_error.resultado_valor := v_resultado_valor;
    anular_tx_entrada_con_error.resultado_mensaje := v_resultado_mensaje;
    END anular_tx_entrada_con_error;
  
  /* **************************************************************
  PROCEDURE actualizar_config_monitoreo
    Actualiza la tabla: CONFIGURACION_MONITOREO, registro a registro
  *****************************************************************/
    PROCEDURE actualizar_config_monitoreo (
        id_entidad          IN  mtobj.configuracion_monitoreo.id_entidad%TYPE,
        correo_soporte  IN  mtobj.configuracion_monitoreo.correo_soporte%TYPE,
        sla_nombre          IN  mtobj.configuracion_monitoreo_det.sla_nombre%TYPE,
        sla_valor               IN  mtobj.configuracion_monitoreo_det.sla_valor%TYPE,
        estado          IN  mtobj.configuracion_monitoreo_det.estado%TYPE )
    IS
        v_count_entidad     NUMBER;
        v_count_entidad_sla NUMBER;
    BEGIN     
      
        SELECT COUNT(1)
            INTO v_count_entidad
        FROM mtobj.configuracion_monitoreo
        WHERE id_entidad = actualizar_config_monitoreo.id_entidad;
            
        SELECT COUNT(1)
            INTO v_count_entidad_sla
        FROM mtobj.configuracion_monitoreo_det
        WHERE id_entidad = actualizar_config_monitoreo.id_entidad 
            AND sla_nombre = actualizar_config_monitoreo.sla_nombre;
            
        IF v_count_entidad < 1 THEN
            -- Insert de Cabecera y Detalle
            INSERT INTO mtobj.configuracion_monitoreo(id_entidad, correo_soporte)
                VALUES (actualizar_config_monitoreo.id_entidad,
                        actualizar_config_monitoreo.correo_soporte);
                    
            INSERT INTO mtobj.configuracion_monitoreo_det(id_entidad, sla_nombre, sla_valor, estado)
                VALUES (actualizar_config_monitoreo.id_entidad,
                        actualizar_config_monitoreo.sla_nombre,
                        actualizar_config_monitoreo.sla_valor,
                        actualizar_config_monitoreo.estado);
        ELSE
            -- Update de la Cabecera
            UPDATE mtobj.configuracion_monitoreo
                SET correo_soporte = actualizar_config_monitoreo.correo_soporte            
                WHERE id_entidad = actualizar_config_monitoreo.id_entidad;
            
            -- Validar si es Insert o Update del Detalle
            IF v_count_entidad_sla < 1 THEN
                INSERT INTO mtobj.configuracion_monitoreo_det(id_entidad, sla_nombre, sla_valor, estado)
                    VALUES (actualizar_config_monitoreo.id_entidad,
                            actualizar_config_monitoreo.sla_nombre,
                            actualizar_config_monitoreo.sla_valor,
                            actualizar_config_monitoreo.estado);
            ELSE
                UPDATE mtobj.configuracion_monitoreo_det
                SET sla_valor = actualizar_config_monitoreo.sla_valor,            
                    estado = actualizar_config_monitoreo.estado
                WHERE id_entidad = actualizar_config_monitoreo.id_entidad
                    AND sla_nombre = actualizar_config_monitoreo.sla_nombre;            
            END IF;
        END IF;

    END actualizar_config_monitoreo;

  /* **************************************************************
  PROCEDURE obtener_config_monitoreo
      Devuelve un cursor con los datos de cofiguración de monitoreo
  *****************************************************************/  
  PROCEDURE obtener_config_monitoreo  (
        entidad_id      IN  NUMBER,
        tCursor             OUT cur_Tabla   -- Cursor de salida
        )
  IS
      v_entidad_id   VARCHAR2(50);
      v_Sql          CLOB;
    BEGIN
    
    v_entidad_id := '';
    IF entidad_id is NOT NULL THEN
       v_entidad_id := devolverParametro('cm.id_entidad',entidad_id,true);
    END IF;
    
    v_Sql := 'SELECT '||
                ' cmd.id_entidad, cmd.sla_nombre, cmd.sla_valor ' ||
                ' FROM mtobj.configuracion_monitoreo cm, mtobj.configuracion_monitoreo_det cmd ' ||
                ' WHERE cm.id_entidad = cmd.id_entidad '||
                ' and cmd.estado = ''A'' '||
                '  '||v_entidad_id;
                
    dbms_output.put_line('[LOG - obtener_config_monitoreo] v_Sql: ' || v_Sql);
    
    OPEN tCursor FOR v_Sql;
    obtener_config_monitoreo.tCursor := tCursor;  
    END obtener_config_monitoreo;
  
  /* **************************************************************
  PROCEDURE detener_transmisiones
      Actualiza el estado de la transmisión de salida para que no esté disponible para ser leída por la Entidad. 
  *****************************************************************/  
  PROCEDURE detener_transmisiones  (
        entidad_id_in           IN  NUMBER,
    fecha_inicio          IN    DATE,       -- Fecha de inicio
        fecha_fin               IN  DATE,       -- Fecha de fin
        resultado_valor     OUT NUMBER,
        resultado_mensaje   OUT VARCHAR2
        )
  IS
    v_resultado_valor   NUMBER;
    v_resultado_mensaje   VARCHAR2(200);
    BEGIN
    
    dbms_output.put_line('[LOG - detener_transmisiones]');
    v_resultado_valor := 1;
    
        IF entidad_id_in is not null THEN
      --  10:   POR ENVIAR EN PARTES
      --  1:    POR ENVIAR A E
      update veobj.transmision 
        set eve_id = 10
        where entidad_id = entidad_id_in
          and eve_id = 1
          and fecha_registro > fecha_inicio
          and fecha_registro < fecha_fin;
      --raise_application_error( -20001, 'La detención de transmisiones tuvo errores.');
      
      IF sql%rowcount = 0 THEN
        v_resultado_valor := 1;
        v_resultado_mensaje := 'No hay transmisiones por detener en la entidad.';
      ELSE 
        v_resultado_valor := 0;
        v_resultado_mensaje := 'La detención de transmisiones fue realizada correctamente.';
      END IF;
    END IF;
    
    detener_transmisiones.resultado_valor := v_resultado_valor;
    detener_transmisiones.resultado_mensaje := v_resultado_mensaje;
    END detener_transmisiones;
  
  /* **************************************************************
  PROCEDURE habilitar_transmisiones
      Actualiza el estado de la transmisión de salida para que pueda volver a estar disponible para ser leída por la entidad.
  *****************************************************************/  
  PROCEDURE habilitar_transmisiones  (
        ve_id_in            IN  NUMBER,
        resultado_valor     OUT NUMBER,
        resultado_mensaje   OUT VARCHAR2
        )
  IS
    v_eve_estado_tmp    NUMBER;
    v_resultado_valor   NUMBER;
    v_resultado_mensaje   VARCHAR2(200);
    BEGIN
    
    dbms_output.put_line('[LOG - habilitar_transmisiones]');
    -- Inicializamos en 0, es decir no hay registro o valor
    v_eve_estado_tmp := 0;
    
    -- Validamos el Parametro VE_ID
    IF ve_id_in is not null THEN
      -- Verificar si existe la transmision
      select count(1)
            into v_eve_estado_tmp
          from veobj.transmision t 
          where t.ve_id = ve_id_in;
           dbms_output.put_line('[LOG - habilitar_transmisiones - v_eve_estado_tmp]' || v_eve_estado_tmp);
      CASE 
        WHEN v_eve_estado_tmp = 0 THEN  -- No hay registros
          v_resultado_valor := 1;
          v_resultado_mensaje := 'La transmisión ' || ve_id_in || ' no pudo ser procesada correctamente. Error: No existe.';
        ELSE
          -- Validación del estado
          select t.eve_id
              into v_eve_estado_tmp
            from veobj.transmision t 
            where t.ve_id = ve_id_in;
            
           IF v_eve_estado_tmp = 10 THEN  -- Estado 10
             v_resultado_valor := 0;
           ELSE
             v_resultado_valor := 1;
              v_resultado_mensaje := 'La transmisión ' || ve_id_in || ' no pudo ser procesada correctamente. Error: Estado incorrecto.';
           END IF;          
      END CASE;
    END IF;
    
        IF v_resultado_valor = 0 THEN
      --  10:   POR ENVIAR EN PARTES
      --  1:    POR ENVIAR A E
      update veobj.transmision 
        set eve_id = 1
        where ve_id = ve_id_in
          and eve_id = 10;
      --raise_application_error( -20001, 'La detención de transmisiones tuvo errores.');
      
      IF sql%rowcount = 0 THEN
        v_resultado_valor := 1;
        v_resultado_mensaje := 'La transmisión ' || ve_id_in || ' no pudo ser procesada correctamente. Error: Error Genérico.';
      ELSE 
        v_resultado_valor := 0;
        v_resultado_mensaje := 'La transmisión ' || ve_id_in || ' fue habilitada correctamente.';
      END IF;
    END IF;
    
    habilitar_transmisiones.resultado_valor := v_resultado_valor;
    habilitar_transmisiones.resultado_mensaje := v_resultado_mensaje;
    
    END habilitar_transmisiones;
  
  /* **************************************************************
  FUNCTION devolverParametro
      Validacion de parametros de entrada
      i. Todos: '%'
      ii.Múltiples valores: Formato: <tipo1>&<tipo2>&<tipo3 --> 1&2&3
  *****************************************************************/
  FUNCTION devolverParametro (
      pNombre        VARCHAR2,
      pCadena        VARCHAR2,
      agregarAND     BOOLEAN 
   ) RETURN          VARCHAR2
   IS
      v_pCadena  VARCHAR2(100);
      v_temporal VARCHAR2(100);
   BEGIN
      IF pCadena = '%' THEN -- vacio
         v_pCadena := ' ';
      ELSIF  instr(pCadena,'|') > 0 THEN    -- nombre in (valor1, valor2)
         v_temporal := ''''||','||'''';
         v_pCadena := pNombre|| ' in (''' || REPLACE(pCadena, '|', v_temporal) ||''')';
         IF agregarAND = true THEN -- vacio
            v_pCadena := ' and '||v_pCadena;
         ELSE 
            v_pCadena := v_pCadena||' and ';
         END IF;
      ELSE   -- nombre = valor1
        v_pCadena := pNombre||' = '''||pCadena||'''';
        IF agregarAND = true THEN -- vacio
           v_pCadena := ' and '||v_pCadena;
        ELSE 
           v_pCadena := v_pCadena||' and ';
        END IF;
      END IF;
      
      RETURN v_pCadena;
   END devolverParametro;
   
  /* **************************************************************
  FUNCTION obtener_sla_por_entidad
      Devuelve el valor de un SLA
      Parametros de entrada: id de la entidad y el nombre del sla
  *****************************************************************/
   FUNCTION obtener_sla_por_entidad (
      pentidad_id        NUMBER,
      psla_nombre        VARCHAR2
   ) RETURN          NUMBER
   IS
      v_sla_valor  VARCHAR2(100);
   BEGIN
   
      SELECT sla_valor
        INTO v_sla_valor
        FROM MTOBJ.CONFIGURACION_MONITOREO_DET
       WHERE id_entidad = pentidad_id
         AND sla_nombre = psla_nombre
         AND estado='A';
      
      RETURN v_sla_valor;
   END obtener_sla_por_entidad;
   
  /* **************************************************************
  FUNCTION resultado_mensaje_texto
      Devuelve un mensaje con el resultado de la operación
  *****************************************************************/
   FUNCTION resultado_mensaje_texto (
      transmision_id    NUMBER,
      estado            NUMBER,
      tipo_mensaje      VARCHAR2,
      texto_error       VARCHAR2
   ) RETURN          VARCHAR2
   IS
      v_mensaje_texto  VARCHAR2(200);
   BEGIN
      IF estado = 0 THEN  -- Caso con EXITO
        IF tipo_mensaje = 'reenviar' THEN 
           v_mensaje_texto := 'La transmisión ' || transmision_id || ' fue reenviada correctamente';
        ELSIF  tipo_mensaje = 'reprocesar'  THEN 
          v_mensaje_texto := 'La transmisión ' || transmision_id || ' fue reprocesada correctamente';
        ELSIF  tipo_mensaje = 'reprocesar N8'  THEN 
          v_mensaje_texto := 'La transmisión ' || transmision_id || ' (N8) fue reprocesada correctamente';
        ELSIF  tipo_mensaje = 'anular'  THEN 
          v_mensaje_texto := 'La transmisión ' || transmision_id || ' fue anulada correctamente';
        END IF;
      ELSE   -- Caso con ERROR
        IF tipo_mensaje = 'reenviar' THEN 
          v_mensaje_texto := 'La transmisión ' || transmision_id || ' no pudo ser reenviada. Error: ' || texto_error;
        ELSIF  tipo_mensaje = 'reprocesar'  THEN 
          v_mensaje_texto := 'La transmisión ' || transmision_id || ' no pudo ser reprocesada. Error: ' || texto_error;
        ELSIF  tipo_mensaje = 'reprocesar N8'  THEN 
          v_mensaje_texto := 'La transmisión ' || transmision_id || ' (N8) no pudo ser reprocesada. Error: ' || texto_error;
        ELSIF  tipo_mensaje = 'anular'  THEN 
          v_mensaje_texto := 'La transmisión ' || transmision_id || ' no pudo ser anulada. Error: ' || texto_error;
        END IF;
      END IF;
      
      RETURN v_mensaje_texto;
      
   END resultado_mensaje_texto;
   
END proyecto_bus; 