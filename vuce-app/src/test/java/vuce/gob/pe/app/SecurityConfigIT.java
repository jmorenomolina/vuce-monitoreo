/*
 * Copyright 2016-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package vuce.gob.pe.app;

import vuce.gob.pe.app.SecurityConfig;
import org.junit.Ignore;
import org.junit.Test;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class SecurityConfigIT {

	@Test(expected = RuntimeException.class)
        @Ignore
	public void exceptionOnConfigureNull() {
		new SecurityConfig().configure((HttpSecurity) null);
	}

}