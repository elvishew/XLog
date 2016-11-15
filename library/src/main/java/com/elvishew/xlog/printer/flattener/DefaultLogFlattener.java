/*
 * Copyright 2015 Elvis Hew
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.elvishew.xlog.printer.flattener;

import com.elvishew.xlog.LogLevel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Simply join the timestamp, log level, tag and message together.
 */
public class DefaultLogFlattener implements LogFlattener {

    @Override
    public CharSequence flatten(int logLevel, String tag, String message) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd HH:mm:ss", Locale.US);
        Date curDate = new Date(System.currentTimeMillis());
        formatter.format(curDate);

        return formatter.format(curDate)
                + '|' + LogLevel.getShortLevelName(logLevel)
                + '|' + tag
                + '|' + message;
    }
}
