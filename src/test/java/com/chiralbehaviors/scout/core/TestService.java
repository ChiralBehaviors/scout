/**
 * Copyright (c) 2014 Chiral Behaviors, LLC, all rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.chiralbehaviors.scout.core;

import java.util.concurrent.TimeUnit;

import com.chiralbehaviors.scout.rest.Service;

/**
 * @author hparry
 *
 */
public class TestService implements Service {

    boolean isGreen = true;

    /* (non-Javadoc)
     * @see com.chiralbehaviors.scout.rest.Service#getInterval()
     */
    @Override
    public int getInterval() {
        return 10;
    }

    /* (non-Javadoc)
     * @see com.chiralbehaviors.scout.rest.Service#getName()
     */
    @Override
    public String getName() {
        return "My Test Service";
    }

    /* (non-Javadoc)
     * @see com.chiralbehaviors.scout.rest.Service#getTimeUnit()
     */
    @Override
    public TimeUnit getTimeUnit() {
        return TimeUnit.SECONDS;
    }

    /* (non-Javadoc)
     * @see com.chiralbehaviors.scout.rest.Service#isGreen()
     */
    @Override
    public boolean isGreen() {
        return isGreen;
    }

    /* (non-Javadoc)
     * @see com.chiralbehaviors.scout.rest.Service#updateStatus()
     */
    @Override
    public void updateStatus() {
        isGreen = Math.floor(Math.random() * 10) % 2 == 0;

    }

}
