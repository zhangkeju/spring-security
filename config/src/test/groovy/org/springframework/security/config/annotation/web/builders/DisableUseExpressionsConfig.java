/*
 * Copyright 2002-2013 the original author or authors.
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
package org.springframework.security.config.annotation.web.builders;

import org.springframework.security.config.annotation.web.configuration.BaseWebConfig;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.UrlAuthorizationConfigurer;

@EnableWebSecurity
public class DisableUseExpressionsConfig extends BaseWebConfig {
	// @formatter:off
	protected void configure(HttpSecurity http) throws Exception {
		// This config is also on UrlAuthorizationConfigurer javadoc
		http
			.apply(new UrlAuthorizationConfigurer<>(getApplicationContext())).getRegistry()
				.antMatchers("/users**", "/sessions/**").hasRole("USER")
				.antMatchers("/signup").hasRole("ANONYMOUS")
				.anyRequest().hasRole("USER");
	}
	// @formatter:on
}
