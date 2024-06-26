
# 
## 
**URL:** `http://localhost:9321/idle/add`

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
idleName|string|闲置物名称|false|-
idleDetails|string|详情|false|-
pictureList|string|图集|false|-
idlePrice|number|价格|false|-
idlePlace|string|发货地区|false|-
idleLabel|int32|分类标签|false|-
releaseTime|string|发布时间|false|-
idleStatus|int8|状态（发布1、下架2、删除0）|false|-
userId|int64|用户主键id|false|-
user|object|No comments found.|false|-
└─id|int64|自增主键|false|-
└─accountNumber|string|账号（手机号）|false|-
└─userPassword|string|登录密码|false|-
└─nickname|string|昵称|false|-
└─avatar|string|头像|false|-
└─signInTime|string|注册时间|false|-
└─userStatus|int8|No comments found.|false|-

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json; charset=utf-8' -i http://localhost:9321/idle/add?shUserId=163 --data '{
  "id": 587,
  "idleName": "marcelene.friesen",
  "idleDetails": "fq9hf1",
  "pictureList": "sa44pd",
  "idlePrice": 500,
  "idlePlace": "gihhwf",
  "idleLabel": 515,
  "releaseTime": "2024-06-22 08:38:44",
  "idleStatus": 90,
  "userId": 689,
  "user": {
    "id": 496,
    "accountNumber": "6uow50",
    "userPassword": "og9h12",
    "nickname": "fannie.kris",
    "avatar": "v4bujb",
    "signInTime": "2024-06-22 08:38:44",
    "userStatus": 122
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
  "status_code": 916,
  "msg": "8lpa99",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/idle/info`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
id|int64|No comments found.|true|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/idle/info?id=144
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
  "status_code": 409,
  "msg": "8exjeo",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/idle/all`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
shUserId|string|No comments found.|true|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/idle/all?shUserId=163
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
  "status_code": 996,
  "msg": "k7lbvh",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/idle/find`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
findValue|string|No comments found.|false|-
page|int32|No comments found.|false|-
nums|int32|No comments found.|false|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/idle/find?findValue=eqwfft&page=1&nums=929
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
  "status_code": 269,
  "msg": "f5zoio",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/idle/lable`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
idleLabel|int32|No comments found.|true|-
page|int32|No comments found.|false|-
nums|int32|No comments found.|false|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/idle/lable?idleLabel=186&nums=270&page=1
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
  "status_code": 48,
  "msg": "acytgx",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/idle/update`

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
idleName|string|闲置物名称|false|-
idleDetails|string|详情|false|-
pictureList|string|图集|false|-
idlePrice|number|价格|false|-
idlePlace|string|发货地区|false|-
idleLabel|int32|分类标签|false|-
releaseTime|string|发布时间|false|-
idleStatus|int8|状态（发布1、下架2、删除0）|false|-
userId|int64|用户主键id|false|-
user|object|No comments found.|false|-
└─id|int64|自增主键|false|-
└─accountNumber|string|账号（手机号）|false|-
└─userPassword|string|登录密码|false|-
└─nickname|string|昵称|false|-
└─avatar|string|头像|false|-
└─signInTime|string|注册时间|false|-
└─userStatus|int8|No comments found.|false|-

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json; charset=utf-8' -i http://localhost:9321/idle/update?shUserId=163 --data '{
  "id": 514,
  "idleName": "marcelene.friesen",
  "idleDetails": "ocbu6d",
  "pictureList": "op58lf",
  "idlePrice": 33,
  "idlePlace": "3c8yeh",
  "idleLabel": 108,
  "releaseTime": "2024-06-22 08:38:45",
  "idleStatus": 117,
  "userId": 295,
  "user": {
    "id": 503,
    "accountNumber": "qvzfr2",
    "userPassword": "vwbwn7",
    "nickname": "fannie.kris",
    "avatar": "545qy8",
    "signInTime": "2024-06-22 08:38:45",
    "userStatus": 52
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
  "status_code": 78,
  "msg": "5734vu",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

