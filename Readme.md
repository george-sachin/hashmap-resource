### Hashmap Resource REST API
\===============================================================

Resource Entity

[ Base URL: [localhost:8080](http://localhost:8080/) ]

\===============================================================

GET /resource/all

Description: Retrieve all Resources in Hashmap

Response: object (body)



|**Key**|**Type**|**Description**|
| :- | :- | :- |
|responseCode|Integer |1 if request is successful else 0 |
|responseMessage|String|Message for Success or Failure Reason|
|result|Array<Object<String, String>>|Hashmap Resources|

Example:

{

`    `"responseCode": 1,

`    `"responseMessage": "SUCCESS",

`    `"result": [

`        `{

`            `"k\_5": "v\_5",

`            `"k\_4": "v\_4",

`            `"k\_7": "v\_7",

`            `"k\_6": "v\_6",

`            `"k\_9": "v\_9",

`            `"k\_8": "v\_8",

`            `"k\_1": "v\_1",

`            `"k\_3": "v\_3",

`            `"k\_2": "v\_2"

`        `}

`    `]

}

\===============================================================

POST /resource/create

Description: Create Hashmap Resources

Request: Json of Hashmap Resources to be created. Resource will be created only if resource does not exists, will not be created if resource exists

{"key1": "val1",

"key22": "val2",

"key33": "val3",

"key4": "val4",

"key55": "val5"

}


Response: object (body)



|**Key**|**Type**|**Description**|
| :- | :- | :- |
|responseCode|Integer |1 if request is successful else 0 |
|responseMessage|String|Message for Success or Failure Reason|
|result|Array<Object>|Result list of each created resource and its respective response|
||message|Message for Success or Failure Reason for each resource|
||status|True if resource created else false |
||resourceKey|Key of the resource|

Example:

{

`    `"responseCode": 1,

`    `"responseMessage": "SUCCESS",

`    `"result": [

`        `[

`            `{

`                `"message": "Key exists. Please update existing resource!",

`                `"status": false,

`                `"resourceKey": "key1"

`            `},

`            `{

`                `"message": "Key exists. Please update existing resource!",

`                `"status": false,

`                `"resourceKey": "key4"

`            `},

`            `{

`                `"message": "Created resource!",

`                `"status": true,

`                `"resourceKey": "key22"

`            `},

`            `{

`                `"message": "Created resource!",

`                `"status": true,

`                `"resourceKey": "key33"

`            `},

`            `{

`                `"message": "Created resource!",

`                `"status": true,

`                `"resourceKey": "key55"

`            `}

`        `]

`    `]

}

\===============================================================

GET /resource/retrieve/{key}

Description: Retrieve resources in Hashmap for a key. Resource will be retrieved only if resource exists, will not be retrieved if resource does not exist

Response: object (body)



|**Key**|**Type**|**Description**|
| :- | :- | :- |
|responseCode|Integer |1 if request is successful else 0 |
|responseMessage|String|Message for Success or Failure Reason|
|result|Array<String>|Value of Resource|

Example:

If Resource exists

{

`    `"responseCode": 1,

`    `"responseMessage": "SUCCESS",

`    `"result": [

`        `"val1"

`    `]

}

If Resource does not exist

{

`    `"responseCode": 0,

`    `"responseMessage": "Key Does not exist",

`    `"result": []

}

\===============================================================

UPDATE /resource/update

Description: Create Hashmap Resources

Request: Json of Hashmap Resources to be updated. Resource will be updated only if resource exists, will not be updated if resource does not exist

{"key1": "val101",

"key32": "val222"}}

Response: object (body)



|**Key**|**Type**|**Description**|
| :- | :- | :- |
|responseCode|Integer |1 if request is successful else 0 |
|responseMessage|String|Message for Success or Failure Reason|
|result|Array<Object>|Result list of each updated resource and its respective response|
||message|Message for Success or Failure Reason for each resource|
||status|True if resource updated else false |
||resourceKey|Key of the resource|

Example:

{

`    `"responseCode": 1,

`    `"responseMessage": "SUCCESS",

`    `"result": [

`        `{

`            `"message": "Updated resource!",

`            `"status": true,

`            `"resourceKey": "key1"

`        `},

`        `{

`            `"message": "Key does not exist. Please create resource!",

`            `"status": false,

`            `"resourceKey": "key32"

`        `}

`    `]

}

\===============================================================

DELETE /resource/delete/{key}

Description: Delete Resource in Hashmap for a key. Resource will be deleted only if resource exists, will not be Description: Retrieve resources in Hashmap for a key.

Response: object (body)



|**Key**|**Type**|**Description**|
| :- | :- | :- |
|responseCode|Integer |1 if request is successful else 0 |
|responseMessage|String|Message for Success or Failure Reason|
|result|Array<Boolean>|Boolean result for delete request. True if deleted, False if not deleted|

Example:

If Resource exists

{

`    `"responseCode": 1,

`    `"responseMessage": "SUCCESS",

`    `"result": [

`        `true

`    `]

}

If Resource does not exist

{

`    `"responseCode": 0,

`    `"responseMessage": "Key Does not exist",

`    `"result": [

`        `false

`    `]

}

\===============================================================

Codebase

\===============================================================

Concurrent Hashmap

Using Apache Jmeter to hit multiple requests concurrently at the same time

`	`Created 10 Resources concurrently

`	`Updated 10 Resources using 10 threads

`	`Resources get updated without any error

