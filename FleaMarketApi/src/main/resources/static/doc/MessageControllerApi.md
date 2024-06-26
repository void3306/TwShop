
# 
## 
**URL:** `http://localhost:9321/message/send`

**Type:** `POST`


**Content-Type:** `application/json; charset=utf-8`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
shUserId|string|No comments found.|true|-

**Body-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
id|int64|自增主键|false|-
userId|int64|用户主键id|false|-
fromU|object|No comments found.|false|-
└─id|int64|自增主键|false|-
└─accountNumber|string|账号（手机号）|false|-
└─userPassword|string|登录密码|false|-
└─nickname|string|昵称|false|-
└─avatar|string|头像|false|-
└─signInTime|string|注册时间|false|-
└─userStatus|int8|No comments found.|false|-
idleId|int64|闲置主键id|false|-
idle|object|No comments found.|false|-
└─id|int64|自增主键|false|-
└─idleName|string|闲置物名称|false|-
└─idleDetails|string|详情|false|-
└─pictureList|string|图集|false|-
└─idlePrice|number|价格|false|-
└─idlePlace|string|发货地区|false|-
└─idleLabel|int32|分类标签|false|-
└─releaseTime|string|发布时间|false|-
└─idleStatus|int8|状态（发布1、下架2、删除0）|false|-
└─userId|int64|用户主键id|false|-
└─user|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|自增主键|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─accountNumber|string|账号（手机号）|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─userPassword|string|登录密码|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nickname|string|昵称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─avatar|string|头像|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─signInTime|string|注册时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─userStatus|int8|No comments found.|false|-
content|string|留言内容|false|-
createTime|string|留言时间|false|-
toUser|int64|所回复的用户|false|-
toU|object|No comments found.|false|-
└─id|int64|自增主键|false|-
└─accountNumber|string|账号（手机号）|false|-
└─userPassword|string|登录密码|false|-
└─nickname|string|昵称|false|-
└─avatar|string|头像|false|-
└─signInTime|string|注册时间|false|-
└─userStatus|int8|No comments found.|false|-
toMessage|int64|所回复的留言|false|-

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json; charset=utf-8' -i http://localhost:9321/message/send?shUserId=163 --data '{
  "id": 569,
  "userId": 488,
  "fromU": {
    "id": 821,
    "accountNumber": "yemuzm",
    "userPassword": "9n0cfc",
    "nickname": "fannie.kris",
    "avatar": "ghlly4",
    "signInTime": "2024-06-22 08:38:45",
    "userStatus": 46
  },
  "idleId": 803,
  "idle": {
    "id": 742,
    "idleName": "marcelene.friesen",
    "idleDetails": "cp8hjv",
    "pictureList": "6jxnbq",
    "idlePrice": 146,
    "idlePlace": "hgyw0f",
    "idleLabel": 321,
    "releaseTime": "2024-06-22 08:38:45",
    "idleStatus": 14,
    "userId": 350,
    "user": {
      "id": 113,
      "accountNumber": "uaih4f",
      "userPassword": "f7rdlr",
      "nickname": "fannie.kris",
      "avatar": "r1ej6v",
      "signInTime": "2024-06-22 08:38:45",
      "userStatus": 30
    }
  },
  "content": "1z5gye",
  "createTime": "2024-06-22 08:38:45",
  "toUser": 194,
  "toU": {
    "id": 551,
    "accountNumber": "y9m5fj",
    "userPassword": "zkplwk",
    "nickname": "fannie.kris",
    "avatar": "ee9ha5",
    "signInTime": "2024-06-22 08:38:45",
    "userStatus": 22
  },
  "toMessage": 976,
  "toM": {
    "$ref": "..."
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
status_code|int32|No comments found.|-
msg|string|No comments found.|-
data|object|No comments found.|-

**Response-example:**
```
{
  "status_code": 425,
  "msg": "az0066",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/message/info`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
id|int64|No comments found.|true|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/message/info?id=463
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
status_code|int32|No comments found.|-
msg|string|No comments found.|-
data|object|No comments found.|-

**Response-example:**
```
{
  "status_code": 926,
  "msg": "s7i42b",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/message/idle`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
idleId|int64|No comments found.|true|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/message/idle?idleId=669
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
status_code|int32|No comments found.|-
msg|string|No comments found.|-
data|object|No comments found.|-

**Response-example:**
```
{
  "status_code": 284,
  "msg": "r0ftar",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/message/my`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
shUserId|string|No comments found.|true|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/message/my?shUserId=163
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
status_code|int32|No comments found.|-
msg|string|No comments found.|-
data|object|No comments found.|-

**Response-example:**
```
{
  "status_code": 253,
  "msg": "dx66sv",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/message/delete`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
shUserId|string|No comments found.|true|-
id|int64|No comments found.|true|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/message/delete?shUserId=163&id=304
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
status_code|int32|No comments found.|-
msg|string|No comments found.|-
data|object|No comments found.|-

**Response-example:**
```
{
  "status_code": 987,
  "msg": "a4pmsj",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

