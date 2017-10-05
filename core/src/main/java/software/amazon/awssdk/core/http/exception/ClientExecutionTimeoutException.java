/*
 * Copyright 2010-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package software.amazon.awssdk.http.exception;

import software.amazon.awssdk.SdkClientException;
import software.amazon.awssdk.annotation.SdkPublicApi;

@SdkPublicApi
public class ClientExecutionTimeoutException extends SdkClientException {

    private static final long serialVersionUID = 4861767589924758934L;

    public ClientExecutionTimeoutException() {
        this("Client execution did not complete before the specified timeout configuration.");
    }

    public ClientExecutionTimeoutException(String message) {
        super(message);
    }

}