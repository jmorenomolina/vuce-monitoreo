//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.04.27 a las 04:39:48 PM COT 
//


package ws.crossnet.apn.vuce.mediador.esquema.apn006;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 * 				
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:UniqueID xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm210AccountingE101="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingVoucherMedium:D08B" xmlns:clm210AccountingE201="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryProcessing:D08B" xmlns:clm210AccountingE202="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryCategory:D08B" xmlns:clm210AccountingE203="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryLineCategory:D08B" xmlns:clm210AccountingE302="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryLineSource:D08B" xmlns:clm210AccountingE304="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AlternateCurrencyAmount:D08B" xmlns:clm210AccountingE307="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:TaxExemptionReason:D08B" xmlns:clm210AccountingE501="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingAccountType:D08B" xmlns:clm210AccountingE601="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingAmountType:D08B" xmlns:clm5ISO42173A="urn:un:unece:uncefact:codelist:standard:5:ISO42173A:2009-03-05" xmlns:clm61001="urn:un:unece:uncefact:codelist:standard:UNECE:DocumentNameCode:D08B" xmlns:clm61001Accounting="urn:un:unece:uncefact:codelist:standard:UNECE:DocumentNameCodeAccounting:D08B" xmlns:clm61153="urn:un:unece:uncefact:codelist:standard:UNECE:ReferenceTypeCode:D08B" xmlns:clm61225Acknowledgement="urn:un:unece:uncefact:codelist:standard:UNECE:MessageFunctionCodeAcknowledgement:D08B" xmlns:clm61373="urn:un:unece:uncefact:codelist:standard:UNECE:DocumentStatusCode:D08B" xmlns:clm63035="urn:un:unece:uncefact:codelist:standard:UNECE:PartyRoleCode:D08B" xmlns:clm63055="urn:un:unece:uncefact:codelist:standard:6:3055:D08B" xmlns:clm63131="urn:un:unece:uncefact:codelist:standard:UNECE:AddressType:D08B" xmlns:clm63227="urn:un:unece:uncefact:codelist:standard:UNECE:LocationFunctionCode:D08B" xmlns:clm64405="urn:un:unece:uncefact:codelist:standard:UNECE:StatusCode:D08B" xmlns:clm64405AccountingDebitCredit="urn:un:unece:uncefact:codelist:standard:UNECE:StatusDescriptionCodeAccountingDebitCredit:D08B" xmlns:clm65153="urn:un:unece:uncefact:codelist:standard:UNECE:DutyTaxFeeTypeCode:D08B" xmlns:clm65305="urn:un:unece:uncefact:codelist:standard:UNECE:DutyorTaxorFeeCategoryCode:D08B" xmlns:clm66245="urn:un:unece:uncefact:codelist:standard:UNECE:TemperatureTypeCode:D08B" xmlns:clm66313="urn:un:unece:uncefact:codelist:standard:UNECE:MeasuredAttributeCode:D08B" xmlns:clm67065="urn:un:unece:uncefact:codelist:standard:UNECE:PackageTypeCode:2006" xmlns:clm67085="urn:un:unece:uncefact:codelist:standard:UNECE:CargoTypeClassificationCode:D08B" xmlns:clm67187="urn:un:unece:uncefact:codelist:standard:UNECE:ProcessTypeCode:D08B" xmlns:clm69417="urn:un:unece:uncefact:codelist:standard:UNECE:GovernmentActionCode:D08B" xmlns:clm69651="urn:un:unece:uncefact:codelist:standard:UNECE:ContractTypeCode:D08B" xmlns:clm69653="urn:un:unece:uncefact:codelist:standard:UNECE:CostManagementCode:D08B" xmlns:clm69655="urn:un:unece:uncefact:codelist:standard:UNECE:CostReportingCode:D08B" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08B" xmlns:clm69659="urn:un:unece:uncefact:codelist:standard:UNECE:FundingTypeCode:D08B" xmlns:clm69661="urn:un:unece:uncefact:codelist:standard:UNECE:HierarchicalStructureTypeCode:D08B" xmlns:clm69665="urn:un:unece:uncefact:codelist:standard:UNECE:ProjectTypeCode:D08B" xmlns:clm69667="urn:un:unece:uncefact:codelist:standard:UNECE:ReportingThresholdTriggerType:D08B" xmlns:clm69669="urn:un:unece:uncefact:codelist:standard:UNECE:ResourceCostCategory:D08B" xmlns:clm69671="urn:un:unece:uncefact:codelist:standard:UNECE:ResourcePlanMeasureType:D08B" xmlns:clm69673="urn:un:unece:uncefact:codelist:standard:UNECE:ScheduleTaskRelationshipType:D08B" xmlns:clm69675="urn:un:unece:uncefact:codelist:standard:UNECE:ScheduleTaskType:D08B" xmlns:clm69677="urn:un:unece:uncefact:codelist:standard:UNECE:SecurityClassificationType:D08B" xmlns:clm6ContractorType="urn:un:unece:uncefact:codelist:standard:UNECE:ContractorType:D08B" xmlns:clm6Recommendation19="urn:un:unece:uncefact:codelist:standard:UNECE:TransportModeCode:2" xmlns:clm6Recommendation20="urn:un:unece:uncefact:codelist:standard:6:Recommendation20:5" xmlns:clm6Recommendation20Duration="urn:un:unece:uncefact:codelist:standard:UNECE:MeasurementUnitCommonCodeDuration:4" xmlns:ids5ISO316612A="urn:un:unece:uncefact:identifierlist:standard:5:ISO316612A:SecondEdition2006VI-4" xmlns:qdt="urn:un:unece:uncefact:data:standard:QualifiedDataType:6" xmlns:udt="urn:un:unece:uncefact:data:standard:UnqualifiedDataType:7" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UN02000107&lt;/ccts:UniqueID&gt;
 * </pre>
 * 
 * 				
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Acronym xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm210AccountingE101="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingVoucherMedium:D08B" xmlns:clm210AccountingE201="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryProcessing:D08B" xmlns:clm210AccountingE202="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryCategory:D08B" xmlns:clm210AccountingE203="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryLineCategory:D08B" xmlns:clm210AccountingE302="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryLineSource:D08B" xmlns:clm210AccountingE304="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AlternateCurrencyAmount:D08B" xmlns:clm210AccountingE307="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:TaxExemptionReason:D08B" xmlns:clm210AccountingE501="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingAccountType:D08B" xmlns:clm210AccountingE601="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingAmountType:D08B" xmlns:clm5ISO42173A="urn:un:unece:uncefact:codelist:standard:5:ISO42173A:2009-03-05" xmlns:clm61001="urn:un:unece:uncefact:codelist:standard:UNECE:DocumentNameCode:D08B" xmlns:clm61001Accounting="urn:un:unece:uncefact:codelist:standard:UNECE:DocumentNameCodeAccounting:D08B" xmlns:clm61153="urn:un:unece:uncefact:codelist:standard:UNECE:ReferenceTypeCode:D08B" xmlns:clm61225Acknowledgement="urn:un:unece:uncefact:codelist:standard:UNECE:MessageFunctionCodeAcknowledgement:D08B" xmlns:clm61373="urn:un:unece:uncefact:codelist:standard:UNECE:DocumentStatusCode:D08B" xmlns:clm63035="urn:un:unece:uncefact:codelist:standard:UNECE:PartyRoleCode:D08B" xmlns:clm63055="urn:un:unece:uncefact:codelist:standard:6:3055:D08B" xmlns:clm63131="urn:un:unece:uncefact:codelist:standard:UNECE:AddressType:D08B" xmlns:clm63227="urn:un:unece:uncefact:codelist:standard:UNECE:LocationFunctionCode:D08B" xmlns:clm64405="urn:un:unece:uncefact:codelist:standard:UNECE:StatusCode:D08B" xmlns:clm64405AccountingDebitCredit="urn:un:unece:uncefact:codelist:standard:UNECE:StatusDescriptionCodeAccountingDebitCredit:D08B" xmlns:clm65153="urn:un:unece:uncefact:codelist:standard:UNECE:DutyTaxFeeTypeCode:D08B" xmlns:clm65305="urn:un:unece:uncefact:codelist:standard:UNECE:DutyorTaxorFeeCategoryCode:D08B" xmlns:clm66245="urn:un:unece:uncefact:codelist:standard:UNECE:TemperatureTypeCode:D08B" xmlns:clm66313="urn:un:unece:uncefact:codelist:standard:UNECE:MeasuredAttributeCode:D08B" xmlns:clm67065="urn:un:unece:uncefact:codelist:standard:UNECE:PackageTypeCode:2006" xmlns:clm67085="urn:un:unece:uncefact:codelist:standard:UNECE:CargoTypeClassificationCode:D08B" xmlns:clm67187="urn:un:unece:uncefact:codelist:standard:UNECE:ProcessTypeCode:D08B" xmlns:clm69417="urn:un:unece:uncefact:codelist:standard:UNECE:GovernmentActionCode:D08B" xmlns:clm69651="urn:un:unece:uncefact:codelist:standard:UNECE:ContractTypeCode:D08B" xmlns:clm69653="urn:un:unece:uncefact:codelist:standard:UNECE:CostManagementCode:D08B" xmlns:clm69655="urn:un:unece:uncefact:codelist:standard:UNECE:CostReportingCode:D08B" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08B" xmlns:clm69659="urn:un:unece:uncefact:codelist:standard:UNECE:FundingTypeCode:D08B" xmlns:clm69661="urn:un:unece:uncefact:codelist:standard:UNECE:HierarchicalStructureTypeCode:D08B" xmlns:clm69665="urn:un:unece:uncefact:codelist:standard:UNECE:ProjectTypeCode:D08B" xmlns:clm69667="urn:un:unece:uncefact:codelist:standard:UNECE:ReportingThresholdTriggerType:D08B" xmlns:clm69669="urn:un:unece:uncefact:codelist:standard:UNECE:ResourceCostCategory:D08B" xmlns:clm69671="urn:un:unece:uncefact:codelist:standard:UNECE:ResourcePlanMeasureType:D08B" xmlns:clm69673="urn:un:unece:uncefact:codelist:standard:UNECE:ScheduleTaskRelationshipType:D08B" xmlns:clm69675="urn:un:unece:uncefact:codelist:standard:UNECE:ScheduleTaskType:D08B" xmlns:clm69677="urn:un:unece:uncefact:codelist:standard:UNECE:SecurityClassificationType:D08B" xmlns:clm6ContractorType="urn:un:unece:uncefact:codelist:standard:UNECE:ContractorType:D08B" xmlns:clm6Recommendation19="urn:un:unece:uncefact:codelist:standard:UNECE:TransportModeCode:2" xmlns:clm6Recommendation20="urn:un:unece:uncefact:codelist:standard:6:Recommendation20:5" xmlns:clm6Recommendation20Duration="urn:un:unece:uncefact:codelist:standard:UNECE:MeasurementUnitCommonCodeDuration:4" xmlns:ids5ISO316612A="urn:un:unece:uncefact:identifierlist:standard:5:ISO316612A:SecondEdition2006VI-4" xmlns:qdt="urn:un:unece:uncefact:data:standard:QualifiedDataType:6" xmlns:udt="urn:un:unece:uncefact:data:standard:UnqualifiedDataType:7" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;DT&lt;/ccts:Acronym&gt;
 * </pre>
 * 
 * 				
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:DictionaryEntryName xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm210AccountingE101="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingVoucherMedium:D08B" xmlns:clm210AccountingE201="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryProcessing:D08B" xmlns:clm210AccountingE202="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryCategory:D08B" xmlns:clm210AccountingE203="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryLineCategory:D08B" xmlns:clm210AccountingE302="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryLineSource:D08B" xmlns:clm210AccountingE304="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AlternateCurrencyAmount:D08B" xmlns:clm210AccountingE307="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:TaxExemptionReason:D08B" xmlns:clm210AccountingE501="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingAccountType:D08B" xmlns:clm210AccountingE601="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingAmountType:D08B" xmlns:clm5ISO42173A="urn:un:unece:uncefact:codelist:standard:5:ISO42173A:2009-03-05" xmlns:clm61001="urn:un:unece:uncefact:codelist:standard:UNECE:DocumentNameCode:D08B" xmlns:clm61001Accounting="urn:un:unece:uncefact:codelist:standard:UNECE:DocumentNameCodeAccounting:D08B" xmlns:clm61153="urn:un:unece:uncefact:codelist:standard:UNECE:ReferenceTypeCode:D08B" xmlns:clm61225Acknowledgement="urn:un:unece:uncefact:codelist:standard:UNECE:MessageFunctionCodeAcknowledgement:D08B" xmlns:clm61373="urn:un:unece:uncefact:codelist:standard:UNECE:DocumentStatusCode:D08B" xmlns:clm63035="urn:un:unece:uncefact:codelist:standard:UNECE:PartyRoleCode:D08B" xmlns:clm63055="urn:un:unece:uncefact:codelist:standard:6:3055:D08B" xmlns:clm63131="urn:un:unece:uncefact:codelist:standard:UNECE:AddressType:D08B" xmlns:clm63227="urn:un:unece:uncefact:codelist:standard:UNECE:LocationFunctionCode:D08B" xmlns:clm64405="urn:un:unece:uncefact:codelist:standard:UNECE:StatusCode:D08B" xmlns:clm64405AccountingDebitCredit="urn:un:unece:uncefact:codelist:standard:UNECE:StatusDescriptionCodeAccountingDebitCredit:D08B" xmlns:clm65153="urn:un:unece:uncefact:codelist:standard:UNECE:DutyTaxFeeTypeCode:D08B" xmlns:clm65305="urn:un:unece:uncefact:codelist:standard:UNECE:DutyorTaxorFeeCategoryCode:D08B" xmlns:clm66245="urn:un:unece:uncefact:codelist:standard:UNECE:TemperatureTypeCode:D08B" xmlns:clm66313="urn:un:unece:uncefact:codelist:standard:UNECE:MeasuredAttributeCode:D08B" xmlns:clm67065="urn:un:unece:uncefact:codelist:standard:UNECE:PackageTypeCode:2006" xmlns:clm67085="urn:un:unece:uncefact:codelist:standard:UNECE:CargoTypeClassificationCode:D08B" xmlns:clm67187="urn:un:unece:uncefact:codelist:standard:UNECE:ProcessTypeCode:D08B" xmlns:clm69417="urn:un:unece:uncefact:codelist:standard:UNECE:GovernmentActionCode:D08B" xmlns:clm69651="urn:un:unece:uncefact:codelist:standard:UNECE:ContractTypeCode:D08B" xmlns:clm69653="urn:un:unece:uncefact:codelist:standard:UNECE:CostManagementCode:D08B" xmlns:clm69655="urn:un:unece:uncefact:codelist:standard:UNECE:CostReportingCode:D08B" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08B" xmlns:clm69659="urn:un:unece:uncefact:codelist:standard:UNECE:FundingTypeCode:D08B" xmlns:clm69661="urn:un:unece:uncefact:codelist:standard:UNECE:HierarchicalStructureTypeCode:D08B" xmlns:clm69665="urn:un:unece:uncefact:codelist:standard:UNECE:ProjectTypeCode:D08B" xmlns:clm69667="urn:un:unece:uncefact:codelist:standard:UNECE:ReportingThresholdTriggerType:D08B" xmlns:clm69669="urn:un:unece:uncefact:codelist:standard:UNECE:ResourceCostCategory:D08B" xmlns:clm69671="urn:un:unece:uncefact:codelist:standard:UNECE:ResourcePlanMeasureType:D08B" xmlns:clm69673="urn:un:unece:uncefact:codelist:standard:UNECE:ScheduleTaskRelationshipType:D08B" xmlns:clm69675="urn:un:unece:uncefact:codelist:standard:UNECE:ScheduleTaskType:D08B" xmlns:clm69677="urn:un:unece:uncefact:codelist:standard:UNECE:SecurityClassificationType:D08B" xmlns:clm6ContractorType="urn:un:unece:uncefact:codelist:standard:UNECE:ContractorType:D08B" xmlns:clm6Recommendation19="urn:un:unece:uncefact:codelist:standard:UNECE:TransportModeCode:2" xmlns:clm6Recommendation20="urn:un:unece:uncefact:codelist:standard:6:Recommendation20:5" xmlns:clm6Recommendation20Duration="urn:un:unece:uncefact:codelist:standard:UNECE:MeasurementUnitCommonCodeDuration:4" xmlns:ids5ISO316612A="urn:un:unece:uncefact:identifierlist:standard:5:ISO316612A:SecondEdition2006VI-4" xmlns:qdt="urn:un:unece:uncefact:data:standard:QualifiedDataType:6" xmlns:udt="urn:un:unece:uncefact:data:standard:UnqualifiedDataType:7" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Accounting Entry Processing_ Code. Type&lt;/ccts:DictionaryEntryName&gt;
 * </pre>
 * 
 * 				
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Version xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm210AccountingE101="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingVoucherMedium:D08B" xmlns:clm210AccountingE201="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryProcessing:D08B" xmlns:clm210AccountingE202="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryCategory:D08B" xmlns:clm210AccountingE203="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryLineCategory:D08B" xmlns:clm210AccountingE302="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryLineSource:D08B" xmlns:clm210AccountingE304="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AlternateCurrencyAmount:D08B" xmlns:clm210AccountingE307="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:TaxExemptionReason:D08B" xmlns:clm210AccountingE501="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingAccountType:D08B" xmlns:clm210AccountingE601="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingAmountType:D08B" xmlns:clm5ISO42173A="urn:un:unece:uncefact:codelist:standard:5:ISO42173A:2009-03-05" xmlns:clm61001="urn:un:unece:uncefact:codelist:standard:UNECE:DocumentNameCode:D08B" xmlns:clm61001Accounting="urn:un:unece:uncefact:codelist:standard:UNECE:DocumentNameCodeAccounting:D08B" xmlns:clm61153="urn:un:unece:uncefact:codelist:standard:UNECE:ReferenceTypeCode:D08B" xmlns:clm61225Acknowledgement="urn:un:unece:uncefact:codelist:standard:UNECE:MessageFunctionCodeAcknowledgement:D08B" xmlns:clm61373="urn:un:unece:uncefact:codelist:standard:UNECE:DocumentStatusCode:D08B" xmlns:clm63035="urn:un:unece:uncefact:codelist:standard:UNECE:PartyRoleCode:D08B" xmlns:clm63055="urn:un:unece:uncefact:codelist:standard:6:3055:D08B" xmlns:clm63131="urn:un:unece:uncefact:codelist:standard:UNECE:AddressType:D08B" xmlns:clm63227="urn:un:unece:uncefact:codelist:standard:UNECE:LocationFunctionCode:D08B" xmlns:clm64405="urn:un:unece:uncefact:codelist:standard:UNECE:StatusCode:D08B" xmlns:clm64405AccountingDebitCredit="urn:un:unece:uncefact:codelist:standard:UNECE:StatusDescriptionCodeAccountingDebitCredit:D08B" xmlns:clm65153="urn:un:unece:uncefact:codelist:standard:UNECE:DutyTaxFeeTypeCode:D08B" xmlns:clm65305="urn:un:unece:uncefact:codelist:standard:UNECE:DutyorTaxorFeeCategoryCode:D08B" xmlns:clm66245="urn:un:unece:uncefact:codelist:standard:UNECE:TemperatureTypeCode:D08B" xmlns:clm66313="urn:un:unece:uncefact:codelist:standard:UNECE:MeasuredAttributeCode:D08B" xmlns:clm67065="urn:un:unece:uncefact:codelist:standard:UNECE:PackageTypeCode:2006" xmlns:clm67085="urn:un:unece:uncefact:codelist:standard:UNECE:CargoTypeClassificationCode:D08B" xmlns:clm67187="urn:un:unece:uncefact:codelist:standard:UNECE:ProcessTypeCode:D08B" xmlns:clm69417="urn:un:unece:uncefact:codelist:standard:UNECE:GovernmentActionCode:D08B" xmlns:clm69651="urn:un:unece:uncefact:codelist:standard:UNECE:ContractTypeCode:D08B" xmlns:clm69653="urn:un:unece:uncefact:codelist:standard:UNECE:CostManagementCode:D08B" xmlns:clm69655="urn:un:unece:uncefact:codelist:standard:UNECE:CostReportingCode:D08B" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08B" xmlns:clm69659="urn:un:unece:uncefact:codelist:standard:UNECE:FundingTypeCode:D08B" xmlns:clm69661="urn:un:unece:uncefact:codelist:standard:UNECE:HierarchicalStructureTypeCode:D08B" xmlns:clm69665="urn:un:unece:uncefact:codelist:standard:UNECE:ProjectTypeCode:D08B" xmlns:clm69667="urn:un:unece:uncefact:codelist:standard:UNECE:ReportingThresholdTriggerType:D08B" xmlns:clm69669="urn:un:unece:uncefact:codelist:standard:UNECE:ResourceCostCategory:D08B" xmlns:clm69671="urn:un:unece:uncefact:codelist:standard:UNECE:ResourcePlanMeasureType:D08B" xmlns:clm69673="urn:un:unece:uncefact:codelist:standard:UNECE:ScheduleTaskRelationshipType:D08B" xmlns:clm69675="urn:un:unece:uncefact:codelist:standard:UNECE:ScheduleTaskType:D08B" xmlns:clm69677="urn:un:unece:uncefact:codelist:standard:UNECE:SecurityClassificationType:D08B" xmlns:clm6ContractorType="urn:un:unece:uncefact:codelist:standard:UNECE:ContractorType:D08B" xmlns:clm6Recommendation19="urn:un:unece:uncefact:codelist:standard:UNECE:TransportModeCode:2" xmlns:clm6Recommendation20="urn:un:unece:uncefact:codelist:standard:6:Recommendation20:5" xmlns:clm6Recommendation20Duration="urn:un:unece:uncefact:codelist:standard:UNECE:MeasurementUnitCommonCodeDuration:4" xmlns:ids5ISO316612A="urn:un:unece:uncefact:identifierlist:standard:5:ISO316612A:SecondEdition2006VI-4" xmlns:qdt="urn:un:unece:uncefact:data:standard:QualifiedDataType:6" xmlns:udt="urn:un:unece:uncefact:data:standard:UnqualifiedDataType:7" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;1.0&lt;/ccts:Version&gt;
 * </pre>
 * 
 * 				
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Definition xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm210AccountingE101="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingVoucherMedium:D08B" xmlns:clm210AccountingE201="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryProcessing:D08B" xmlns:clm210AccountingE202="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryCategory:D08B" xmlns:clm210AccountingE203="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryLineCategory:D08B" xmlns:clm210AccountingE302="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryLineSource:D08B" xmlns:clm210AccountingE304="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AlternateCurrencyAmount:D08B" xmlns:clm210AccountingE307="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:TaxExemptionReason:D08B" xmlns:clm210AccountingE501="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingAccountType:D08B" xmlns:clm210AccountingE601="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingAmountType:D08B" xmlns:clm5ISO42173A="urn:un:unece:uncefact:codelist:standard:5:ISO42173A:2009-03-05" xmlns:clm61001="urn:un:unece:uncefact:codelist:standard:UNECE:DocumentNameCode:D08B" xmlns:clm61001Accounting="urn:un:unece:uncefact:codelist:standard:UNECE:DocumentNameCodeAccounting:D08B" xmlns:clm61153="urn:un:unece:uncefact:codelist:standard:UNECE:ReferenceTypeCode:D08B" xmlns:clm61225Acknowledgement="urn:un:unece:uncefact:codelist:standard:UNECE:MessageFunctionCodeAcknowledgement:D08B" xmlns:clm61373="urn:un:unece:uncefact:codelist:standard:UNECE:DocumentStatusCode:D08B" xmlns:clm63035="urn:un:unece:uncefact:codelist:standard:UNECE:PartyRoleCode:D08B" xmlns:clm63055="urn:un:unece:uncefact:codelist:standard:6:3055:D08B" xmlns:clm63131="urn:un:unece:uncefact:codelist:standard:UNECE:AddressType:D08B" xmlns:clm63227="urn:un:unece:uncefact:codelist:standard:UNECE:LocationFunctionCode:D08B" xmlns:clm64405="urn:un:unece:uncefact:codelist:standard:UNECE:StatusCode:D08B" xmlns:clm64405AccountingDebitCredit="urn:un:unece:uncefact:codelist:standard:UNECE:StatusDescriptionCodeAccountingDebitCredit:D08B" xmlns:clm65153="urn:un:unece:uncefact:codelist:standard:UNECE:DutyTaxFeeTypeCode:D08B" xmlns:clm65305="urn:un:unece:uncefact:codelist:standard:UNECE:DutyorTaxorFeeCategoryCode:D08B" xmlns:clm66245="urn:un:unece:uncefact:codelist:standard:UNECE:TemperatureTypeCode:D08B" xmlns:clm66313="urn:un:unece:uncefact:codelist:standard:UNECE:MeasuredAttributeCode:D08B" xmlns:clm67065="urn:un:unece:uncefact:codelist:standard:UNECE:PackageTypeCode:2006" xmlns:clm67085="urn:un:unece:uncefact:codelist:standard:UNECE:CargoTypeClassificationCode:D08B" xmlns:clm67187="urn:un:unece:uncefact:codelist:standard:UNECE:ProcessTypeCode:D08B" xmlns:clm69417="urn:un:unece:uncefact:codelist:standard:UNECE:GovernmentActionCode:D08B" xmlns:clm69651="urn:un:unece:uncefact:codelist:standard:UNECE:ContractTypeCode:D08B" xmlns:clm69653="urn:un:unece:uncefact:codelist:standard:UNECE:CostManagementCode:D08B" xmlns:clm69655="urn:un:unece:uncefact:codelist:standard:UNECE:CostReportingCode:D08B" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08B" xmlns:clm69659="urn:un:unece:uncefact:codelist:standard:UNECE:FundingTypeCode:D08B" xmlns:clm69661="urn:un:unece:uncefact:codelist:standard:UNECE:HierarchicalStructureTypeCode:D08B" xmlns:clm69665="urn:un:unece:uncefact:codelist:standard:UNECE:ProjectTypeCode:D08B" xmlns:clm69667="urn:un:unece:uncefact:codelist:standard:UNECE:ReportingThresholdTriggerType:D08B" xmlns:clm69669="urn:un:unece:uncefact:codelist:standard:UNECE:ResourceCostCategory:D08B" xmlns:clm69671="urn:un:unece:uncefact:codelist:standard:UNECE:ResourcePlanMeasureType:D08B" xmlns:clm69673="urn:un:unece:uncefact:codelist:standard:UNECE:ScheduleTaskRelationshipType:D08B" xmlns:clm69675="urn:un:unece:uncefact:codelist:standard:UNECE:ScheduleTaskType:D08B" xmlns:clm69677="urn:un:unece:uncefact:codelist:standard:UNECE:SecurityClassificationType:D08B" xmlns:clm6ContractorType="urn:un:unece:uncefact:codelist:standard:UNECE:ContractorType:D08B" xmlns:clm6Recommendation19="urn:un:unece:uncefact:codelist:standard:UNECE:TransportModeCode:2" xmlns:clm6Recommendation20="urn:un:unece:uncefact:codelist:standard:6:Recommendation20:5" xmlns:clm6Recommendation20Duration="urn:un:unece:uncefact:codelist:standard:UNECE:MeasurementUnitCommonCodeDuration:4" xmlns:ids5ISO316612A="urn:un:unece:uncefact:identifierlist:standard:5:ISO316612A:SecondEdition2006VI-4" xmlns:qdt="urn:un:unece:uncefact:data:standard:QualifiedDataType:6" xmlns:udt="urn:un:unece:uncefact:data:standard:UnqualifiedDataType:7" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;A character string used to represent the processing of an accounting entry.&lt;/ccts:Definition&gt;
 * </pre>
 * 
 * 				
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:PrimaryRepresentationTerm xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm210AccountingE101="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingVoucherMedium:D08B" xmlns:clm210AccountingE201="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryProcessing:D08B" xmlns:clm210AccountingE202="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryCategory:D08B" xmlns:clm210AccountingE203="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryLineCategory:D08B" xmlns:clm210AccountingE302="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryLineSource:D08B" xmlns:clm210AccountingE304="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AlternateCurrencyAmount:D08B" xmlns:clm210AccountingE307="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:TaxExemptionReason:D08B" xmlns:clm210AccountingE501="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingAccountType:D08B" xmlns:clm210AccountingE601="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingAmountType:D08B" xmlns:clm5ISO42173A="urn:un:unece:uncefact:codelist:standard:5:ISO42173A:2009-03-05" xmlns:clm61001="urn:un:unece:uncefact:codelist:standard:UNECE:DocumentNameCode:D08B" xmlns:clm61001Accounting="urn:un:unece:uncefact:codelist:standard:UNECE:DocumentNameCodeAccounting:D08B" xmlns:clm61153="urn:un:unece:uncefact:codelist:standard:UNECE:ReferenceTypeCode:D08B" xmlns:clm61225Acknowledgement="urn:un:unece:uncefact:codelist:standard:UNECE:MessageFunctionCodeAcknowledgement:D08B" xmlns:clm61373="urn:un:unece:uncefact:codelist:standard:UNECE:DocumentStatusCode:D08B" xmlns:clm63035="urn:un:unece:uncefact:codelist:standard:UNECE:PartyRoleCode:D08B" xmlns:clm63055="urn:un:unece:uncefact:codelist:standard:6:3055:D08B" xmlns:clm63131="urn:un:unece:uncefact:codelist:standard:UNECE:AddressType:D08B" xmlns:clm63227="urn:un:unece:uncefact:codelist:standard:UNECE:LocationFunctionCode:D08B" xmlns:clm64405="urn:un:unece:uncefact:codelist:standard:UNECE:StatusCode:D08B" xmlns:clm64405AccountingDebitCredit="urn:un:unece:uncefact:codelist:standard:UNECE:StatusDescriptionCodeAccountingDebitCredit:D08B" xmlns:clm65153="urn:un:unece:uncefact:codelist:standard:UNECE:DutyTaxFeeTypeCode:D08B" xmlns:clm65305="urn:un:unece:uncefact:codelist:standard:UNECE:DutyorTaxorFeeCategoryCode:D08B" xmlns:clm66245="urn:un:unece:uncefact:codelist:standard:UNECE:TemperatureTypeCode:D08B" xmlns:clm66313="urn:un:unece:uncefact:codelist:standard:UNECE:MeasuredAttributeCode:D08B" xmlns:clm67065="urn:un:unece:uncefact:codelist:standard:UNECE:PackageTypeCode:2006" xmlns:clm67085="urn:un:unece:uncefact:codelist:standard:UNECE:CargoTypeClassificationCode:D08B" xmlns:clm67187="urn:un:unece:uncefact:codelist:standard:UNECE:ProcessTypeCode:D08B" xmlns:clm69417="urn:un:unece:uncefact:codelist:standard:UNECE:GovernmentActionCode:D08B" xmlns:clm69651="urn:un:unece:uncefact:codelist:standard:UNECE:ContractTypeCode:D08B" xmlns:clm69653="urn:un:unece:uncefact:codelist:standard:UNECE:CostManagementCode:D08B" xmlns:clm69655="urn:un:unece:uncefact:codelist:standard:UNECE:CostReportingCode:D08B" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08B" xmlns:clm69659="urn:un:unece:uncefact:codelist:standard:UNECE:FundingTypeCode:D08B" xmlns:clm69661="urn:un:unece:uncefact:codelist:standard:UNECE:HierarchicalStructureTypeCode:D08B" xmlns:clm69665="urn:un:unece:uncefact:codelist:standard:UNECE:ProjectTypeCode:D08B" xmlns:clm69667="urn:un:unece:uncefact:codelist:standard:UNECE:ReportingThresholdTriggerType:D08B" xmlns:clm69669="urn:un:unece:uncefact:codelist:standard:UNECE:ResourceCostCategory:D08B" xmlns:clm69671="urn:un:unece:uncefact:codelist:standard:UNECE:ResourcePlanMeasureType:D08B" xmlns:clm69673="urn:un:unece:uncefact:codelist:standard:UNECE:ScheduleTaskRelationshipType:D08B" xmlns:clm69675="urn:un:unece:uncefact:codelist:standard:UNECE:ScheduleTaskType:D08B" xmlns:clm69677="urn:un:unece:uncefact:codelist:standard:UNECE:SecurityClassificationType:D08B" xmlns:clm6ContractorType="urn:un:unece:uncefact:codelist:standard:UNECE:ContractorType:D08B" xmlns:clm6Recommendation19="urn:un:unece:uncefact:codelist:standard:UNECE:TransportModeCode:2" xmlns:clm6Recommendation20="urn:un:unece:uncefact:codelist:standard:6:Recommendation20:5" xmlns:clm6Recommendation20Duration="urn:un:unece:uncefact:codelist:standard:UNECE:MeasurementUnitCommonCodeDuration:4" xmlns:ids5ISO316612A="urn:un:unece:uncefact:identifierlist:standard:5:ISO316612A:SecondEdition2006VI-4" xmlns:qdt="urn:un:unece:uncefact:data:standard:QualifiedDataType:6" xmlns:udt="urn:un:unece:uncefact:data:standard:UnqualifiedDataType:7" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Code&lt;/ccts:PrimaryRepresentationTerm&gt;
 * </pre>
 * 
 * 				
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:PrimitiveType xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm210AccountingE101="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingVoucherMedium:D08B" xmlns:clm210AccountingE201="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryProcessing:D08B" xmlns:clm210AccountingE202="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryCategory:D08B" xmlns:clm210AccountingE203="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryLineCategory:D08B" xmlns:clm210AccountingE302="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryLineSource:D08B" xmlns:clm210AccountingE304="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AlternateCurrencyAmount:D08B" xmlns:clm210AccountingE307="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:TaxExemptionReason:D08B" xmlns:clm210AccountingE501="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingAccountType:D08B" xmlns:clm210AccountingE601="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingAmountType:D08B" xmlns:clm5ISO42173A="urn:un:unece:uncefact:codelist:standard:5:ISO42173A:2009-03-05" xmlns:clm61001="urn:un:unece:uncefact:codelist:standard:UNECE:DocumentNameCode:D08B" xmlns:clm61001Accounting="urn:un:unece:uncefact:codelist:standard:UNECE:DocumentNameCodeAccounting:D08B" xmlns:clm61153="urn:un:unece:uncefact:codelist:standard:UNECE:ReferenceTypeCode:D08B" xmlns:clm61225Acknowledgement="urn:un:unece:uncefact:codelist:standard:UNECE:MessageFunctionCodeAcknowledgement:D08B" xmlns:clm61373="urn:un:unece:uncefact:codelist:standard:UNECE:DocumentStatusCode:D08B" xmlns:clm63035="urn:un:unece:uncefact:codelist:standard:UNECE:PartyRoleCode:D08B" xmlns:clm63055="urn:un:unece:uncefact:codelist:standard:6:3055:D08B" xmlns:clm63131="urn:un:unece:uncefact:codelist:standard:UNECE:AddressType:D08B" xmlns:clm63227="urn:un:unece:uncefact:codelist:standard:UNECE:LocationFunctionCode:D08B" xmlns:clm64405="urn:un:unece:uncefact:codelist:standard:UNECE:StatusCode:D08B" xmlns:clm64405AccountingDebitCredit="urn:un:unece:uncefact:codelist:standard:UNECE:StatusDescriptionCodeAccountingDebitCredit:D08B" xmlns:clm65153="urn:un:unece:uncefact:codelist:standard:UNECE:DutyTaxFeeTypeCode:D08B" xmlns:clm65305="urn:un:unece:uncefact:codelist:standard:UNECE:DutyorTaxorFeeCategoryCode:D08B" xmlns:clm66245="urn:un:unece:uncefact:codelist:standard:UNECE:TemperatureTypeCode:D08B" xmlns:clm66313="urn:un:unece:uncefact:codelist:standard:UNECE:MeasuredAttributeCode:D08B" xmlns:clm67065="urn:un:unece:uncefact:codelist:standard:UNECE:PackageTypeCode:2006" xmlns:clm67085="urn:un:unece:uncefact:codelist:standard:UNECE:CargoTypeClassificationCode:D08B" xmlns:clm67187="urn:un:unece:uncefact:codelist:standard:UNECE:ProcessTypeCode:D08B" xmlns:clm69417="urn:un:unece:uncefact:codelist:standard:UNECE:GovernmentActionCode:D08B" xmlns:clm69651="urn:un:unece:uncefact:codelist:standard:UNECE:ContractTypeCode:D08B" xmlns:clm69653="urn:un:unece:uncefact:codelist:standard:UNECE:CostManagementCode:D08B" xmlns:clm69655="urn:un:unece:uncefact:codelist:standard:UNECE:CostReportingCode:D08B" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08B" xmlns:clm69659="urn:un:unece:uncefact:codelist:standard:UNECE:FundingTypeCode:D08B" xmlns:clm69661="urn:un:unece:uncefact:codelist:standard:UNECE:HierarchicalStructureTypeCode:D08B" xmlns:clm69665="urn:un:unece:uncefact:codelist:standard:UNECE:ProjectTypeCode:D08B" xmlns:clm69667="urn:un:unece:uncefact:codelist:standard:UNECE:ReportingThresholdTriggerType:D08B" xmlns:clm69669="urn:un:unece:uncefact:codelist:standard:UNECE:ResourceCostCategory:D08B" xmlns:clm69671="urn:un:unece:uncefact:codelist:standard:UNECE:ResourcePlanMeasureType:D08B" xmlns:clm69673="urn:un:unece:uncefact:codelist:standard:UNECE:ScheduleTaskRelationshipType:D08B" xmlns:clm69675="urn:un:unece:uncefact:codelist:standard:UNECE:ScheduleTaskType:D08B" xmlns:clm69677="urn:un:unece:uncefact:codelist:standard:UNECE:SecurityClassificationType:D08B" xmlns:clm6ContractorType="urn:un:unece:uncefact:codelist:standard:UNECE:ContractorType:D08B" xmlns:clm6Recommendation19="urn:un:unece:uncefact:codelist:standard:UNECE:TransportModeCode:2" xmlns:clm6Recommendation20="urn:un:unece:uncefact:codelist:standard:6:Recommendation20:5" xmlns:clm6Recommendation20Duration="urn:un:unece:uncefact:codelist:standard:UNECE:MeasurementUnitCommonCodeDuration:4" xmlns:ids5ISO316612A="urn:un:unece:uncefact:identifierlist:standard:5:ISO316612A:SecondEdition2006VI-4" xmlns:qdt="urn:un:unece:uncefact:data:standard:QualifiedDataType:6" xmlns:udt="urn:un:unece:uncefact:data:standard:UnqualifiedDataType:7" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;String&lt;/ccts:PrimitiveType&gt;
 * </pre>
 * 
 * 				
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:DataTypeQualifierTerm xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm210AccountingE101="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingVoucherMedium:D08B" xmlns:clm210AccountingE201="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryProcessing:D08B" xmlns:clm210AccountingE202="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryCategory:D08B" xmlns:clm210AccountingE203="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryLineCategory:D08B" xmlns:clm210AccountingE302="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryLineSource:D08B" xmlns:clm210AccountingE304="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AlternateCurrencyAmount:D08B" xmlns:clm210AccountingE307="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:TaxExemptionReason:D08B" xmlns:clm210AccountingE501="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingAccountType:D08B" xmlns:clm210AccountingE601="urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingAmountType:D08B" xmlns:clm5ISO42173A="urn:un:unece:uncefact:codelist:standard:5:ISO42173A:2009-03-05" xmlns:clm61001="urn:un:unece:uncefact:codelist:standard:UNECE:DocumentNameCode:D08B" xmlns:clm61001Accounting="urn:un:unece:uncefact:codelist:standard:UNECE:DocumentNameCodeAccounting:D08B" xmlns:clm61153="urn:un:unece:uncefact:codelist:standard:UNECE:ReferenceTypeCode:D08B" xmlns:clm61225Acknowledgement="urn:un:unece:uncefact:codelist:standard:UNECE:MessageFunctionCodeAcknowledgement:D08B" xmlns:clm61373="urn:un:unece:uncefact:codelist:standard:UNECE:DocumentStatusCode:D08B" xmlns:clm63035="urn:un:unece:uncefact:codelist:standard:UNECE:PartyRoleCode:D08B" xmlns:clm63055="urn:un:unece:uncefact:codelist:standard:6:3055:D08B" xmlns:clm63131="urn:un:unece:uncefact:codelist:standard:UNECE:AddressType:D08B" xmlns:clm63227="urn:un:unece:uncefact:codelist:standard:UNECE:LocationFunctionCode:D08B" xmlns:clm64405="urn:un:unece:uncefact:codelist:standard:UNECE:StatusCode:D08B" xmlns:clm64405AccountingDebitCredit="urn:un:unece:uncefact:codelist:standard:UNECE:StatusDescriptionCodeAccountingDebitCredit:D08B" xmlns:clm65153="urn:un:unece:uncefact:codelist:standard:UNECE:DutyTaxFeeTypeCode:D08B" xmlns:clm65305="urn:un:unece:uncefact:codelist:standard:UNECE:DutyorTaxorFeeCategoryCode:D08B" xmlns:clm66245="urn:un:unece:uncefact:codelist:standard:UNECE:TemperatureTypeCode:D08B" xmlns:clm66313="urn:un:unece:uncefact:codelist:standard:UNECE:MeasuredAttributeCode:D08B" xmlns:clm67065="urn:un:unece:uncefact:codelist:standard:UNECE:PackageTypeCode:2006" xmlns:clm67085="urn:un:unece:uncefact:codelist:standard:UNECE:CargoTypeClassificationCode:D08B" xmlns:clm67187="urn:un:unece:uncefact:codelist:standard:UNECE:ProcessTypeCode:D08B" xmlns:clm69417="urn:un:unece:uncefact:codelist:standard:UNECE:GovernmentActionCode:D08B" xmlns:clm69651="urn:un:unece:uncefact:codelist:standard:UNECE:ContractTypeCode:D08B" xmlns:clm69653="urn:un:unece:uncefact:codelist:standard:UNECE:CostManagementCode:D08B" xmlns:clm69655="urn:un:unece:uncefact:codelist:standard:UNECE:CostReportingCode:D08B" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08B" xmlns:clm69659="urn:un:unece:uncefact:codelist:standard:UNECE:FundingTypeCode:D08B" xmlns:clm69661="urn:un:unece:uncefact:codelist:standard:UNECE:HierarchicalStructureTypeCode:D08B" xmlns:clm69665="urn:un:unece:uncefact:codelist:standard:UNECE:ProjectTypeCode:D08B" xmlns:clm69667="urn:un:unece:uncefact:codelist:standard:UNECE:ReportingThresholdTriggerType:D08B" xmlns:clm69669="urn:un:unece:uncefact:codelist:standard:UNECE:ResourceCostCategory:D08B" xmlns:clm69671="urn:un:unece:uncefact:codelist:standard:UNECE:ResourcePlanMeasureType:D08B" xmlns:clm69673="urn:un:unece:uncefact:codelist:standard:UNECE:ScheduleTaskRelationshipType:D08B" xmlns:clm69675="urn:un:unece:uncefact:codelist:standard:UNECE:ScheduleTaskType:D08B" xmlns:clm69677="urn:un:unece:uncefact:codelist:standard:UNECE:SecurityClassificationType:D08B" xmlns:clm6ContractorType="urn:un:unece:uncefact:codelist:standard:UNECE:ContractorType:D08B" xmlns:clm6Recommendation19="urn:un:unece:uncefact:codelist:standard:UNECE:TransportModeCode:2" xmlns:clm6Recommendation20="urn:un:unece:uncefact:codelist:standard:6:Recommendation20:5" xmlns:clm6Recommendation20Duration="urn:un:unece:uncefact:codelist:standard:UNECE:MeasurementUnitCommonCodeDuration:4" xmlns:ids5ISO316612A="urn:un:unece:uncefact:identifierlist:standard:5:ISO316612A:SecondEdition2006VI-4" xmlns:qdt="urn:un:unece:uncefact:data:standard:QualifiedDataType:6" xmlns:udt="urn:un:unece:uncefact:data:standard:UnqualifiedDataType:7" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Accounting Entry Processing&lt;/ccts:DataTypeQualifierTerm&gt;
 * </pre>
 * 
 * 			
 * 
 * <p>Clase Java para AccountingEntryProcessingCodeType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AccountingEntryProcessingCodeType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;urn:un:unece:uncefact:codelist:standard:EDIFICASEU:AccountingEntryProcessing:D08B>AccountingEntryProcessingContentType">
 *       &lt;attribute name="listID" type="{http://www.w3.org/2001/XMLSchema}token" fixed="AccountingE201" />
 *       &lt;attribute name="listAgencyID" type="{urn:un:unece:uncefact:codelist:standard:6:3055:D08B}AgencyIdentificationCodeContentType" fixed="210" />
 *       &lt;attribute name="listVersionID" type="{http://www.w3.org/2001/XMLSchema}token" fixed="D08B" />
 *       &lt;attribute name="listURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountingEntryProcessingCodeType", propOrder = {
    "value"
})
public class AccountingEntryProcessingCodeType {

    @XmlValue
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String value;
    @XmlAttribute(name = "listID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String listID;
    @XmlAttribute(name = "listAgencyID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String listAgencyID;
    @XmlAttribute(name = "listVersionID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String listVersionID;
    @XmlAttribute(name = "listURI")
    @XmlSchemaType(name = "anyURI")
    protected String listURI;

    /**
     * Obtiene el valor de la propiedad value.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Define el valor de la propiedad value.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Obtiene el valor de la propiedad listID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListID() {
        if (listID == null) {
            return "AccountingE201";
        } else {
            return listID;
        }
    }

    /**
     * Define el valor de la propiedad listID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListID(String value) {
        this.listID = value;
    }

    /**
     * Obtiene el valor de la propiedad listAgencyID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListAgencyID() {
        if (listAgencyID == null) {
            return "210";
        } else {
            return listAgencyID;
        }
    }

    /**
     * Define el valor de la propiedad listAgencyID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListAgencyID(String value) {
        this.listAgencyID = value;
    }

    /**
     * Obtiene el valor de la propiedad listVersionID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListVersionID() {
        if (listVersionID == null) {
            return "D08B";
        } else {
            return listVersionID;
        }
    }

    /**
     * Define el valor de la propiedad listVersionID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListVersionID(String value) {
        this.listVersionID = value;
    }

    /**
     * Obtiene el valor de la propiedad listURI.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListURI() {
        return listURI;
    }

    /**
     * Define el valor de la propiedad listURI.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListURI(String value) {
        this.listURI = value;
    }

}
