
# 
## 
**URL:** `http://localhost:9321/favorite/add`

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
id|int64|自增主键id|false|-
createTime|string|加入收藏的时间|false|-
userId|int64|用户主键id|false|-
idleId|int64|闲置物主键id|false|-
idleItem|object|No comments found.|false|-
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

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json; charset=utf-8' -i http://localhost:9321/favorite/add?shUserId=163 --data '{
  "id": 632,
  "createTime": "2024-06-22 08:38:44",
  "userId": 979,
  "idleId": 527,
  "idleItem": {
    "id": 439,
    "idleName": "marcelene.friesen",
    "idleDetails": "bm98pi",
    "pictureList": "j9ujqe",
    "idlePrice": 444,
    "idlePlace": "4k3fms",
    "idleLabel": 203,
    "releaseTime": "2024-06-22 08:38:44",
    "idleStatus": 124,
    "userId": 545,
    "user": {
      "id": 430,
      "accountNumber": "j5nco9",
      "userPassword": "fzwvj9",
      "nickname": "fannie.kris",
      "avatar": "qo5knx",
      "signInTime": "2024-06-22 08:38:44",
      "userStatus": 60
    }
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
  "status_code": 415,
  "msg": "c5gu8i",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/favorite/delete`

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
curl -X GET -i http://localhost:9321/favorite/delete?id=242&shUserId=163
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
  "status_code": 740,
  "msg": "8q9awr",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/favorite/check`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
shUserId|string|No comments found.|true|-
idleId|int64|No comments found.|true|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/favorite/check?shUserId=163&idleId=900
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
  "status_code": 749,
  "msg": "dp124g",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/favorite/my`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
shUserId|string|No comments found.|true|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/favorite/my?shUserId=163
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
  "status_code": 617,
  "msg": "sq6ozo",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

