/*-
 * #%L
 * wcm.io
 * %%
 * Copyright (C) 2017 wcm.io DevOps
 * %%
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
 * #L%
 */
package vars.checkoutScm.jobs

import static io.wcm.devops.jenkins.pipeline.utils.ConfigConstants.*

/**
 * Executes a custom checkout with all supported configuration options that should not use the provided credentialsId
 *
 * @return The script
 * @see vars.checkoutScm.CheckoutScmIT
 */
def execute() {
  checkoutScm((SCM): [
      (SCM_URL)                                : "git@git-ssh.betterdomain.tld/group/project1.git",
      (SCM_CREDENTIALS_ID)                     : 'CUSTOM_CREDENTIAL_ID',
      (SCM_BRANCHES)                           : [[name: 'customBranch']],
      (SCM_DO_GENERATE_SUBMODULE_CONFIGURATION): true,
      (SCM_EXTENSIONS)                         : [[$class: 'CleanBeforeCheckout'], [$class: 'CloneOption', depth: 0, noTags: false, reference: '', shallow: true]],
      (SCM_SUBMODULE_CONFIG)                   : [[$class: 'CustomSubModuleCfg']]
  ])
}

return this
