
# 
## 
**URL:** `http://localhost:9321/order/add`

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
orderNumber|string|订单编号|false|-
userId|int64|用户主键id|false|-
user|object|No comments found.|false|-
└─id|int64|自增主键|false|-
└─accountNumber|string|账号（手机号）|false|-
└─userPassword|string|登录密码|false|-
└─nickname|string|昵称|false|-
└─avatar|string|头像|false|-
└─signInTime|string|注册时间|false|-
└─userStatus|int8|No comments found.|false|-
idleId|int64|闲置物品主键id|false|-
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
orderPrice|number|订单总价|false|-
paymentStatus|int8|支付状态|false|-
paymentWay|string|支付方式|false|-
createTime|string|创建时间|false|-
paymentTime|string|支付时间|false|-
orderStatus|int8|订单状态|false|-
isDeleted|int8|是否删除|false|-

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json; charset=utf-8' -i http://localhost:9321/order/add?shUserId=163 --data '{
  "id": 75,
  "orderNumber": "tgrcsu",
  "userId": 352,
  "user": {
    "id": 408,
    "accountNumber": "sqmq0s",
    "userPassword": "u2tucd",
    "nickname": "fannie.kris",
    "avatar": "zys75e",
    "signInTime": "2024-06-22 08:38:45",
    "userStatus": 99
  },
  "idleId": 124,
  "idleItem": {
    "id": 432,
    "idleName": "marcelene.friesen",
    "idleDetails": "f2rrwz",
    "pictureList": "69xzgd",
    "idlePrice": 54,
    "idlePlace": "utlvw3",
    "idleLabel": 684,
    "releaseTime": "2024-06-22 08:38:45",
    "idleStatus": 35,
    "userId": 167,
    "user": {
      "id": 741,
      "accountNumber": "k70adm",
      "userPassword": "bvifho",
      "nickname": "fannie.kris",
      "avatar": "9mee75",
      "signInTime": "2024-06-22 08:38:45",
      "userStatus": 94
    }
  },
  "orderPrice": 620,
  "paymentStatus": 69,
  "paymentWay": "336ap7",
  "createTime": "2024-06-22 08:38:45",
  "paymentTime": "2024-06-22 08:38:45",
  "orderStatus": 54,
  "isDeleted": 77
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
  "status_code": 358,
  "msg": "vd40i4",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/order/info`

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
curl -X GET -i http://localhost:9321/order/info?shUserId=163&id=377
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
  "status_code": 446,
  "msg": "s7ek8x",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/order/update`

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
orderNumber|string|订单编号|false|-
userId|int64|用户主键id|false|-
user|object|No comments found.|false|-
└─id|int64|自增主键|false|-
└─accountNumber|string|账号（手机号）|false|-
└─userPassword|string|登录密码|false|-
└─nickname|string|昵称|false|-
└─avatar|string|头像|false|-
└─signInTime|string|注册时间|false|-
└─userStatus|int8|No comments found.|false|-
idleId|int64|闲置物品主键id|false|-
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
orderPrice|number|订单总价|false|-
paymentStatus|int8|支付状态|false|-
paymentWay|string|支付方式|false|-
createTime|string|创建时间|false|-
paymentTime|string|支付时间|false|-
orderStatus|int8|订单状态|false|-
isDeleted|int8|是否删除|false|-

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json; charset=utf-8' -i http://localhost:9321/order/update?shUserId=163 --data '{
  "id": 273,
  "orderNumber": "vlhuo4",
  "userId": 393,
  "user": {
    "id": 771,
    "accountNumber": "nq1nki",
    "userPassword": "8dgmwa",
    "nickname": "fannie.kris",
    "avatar": "4oa6yc",
    "signInTime": "2024-06-22 08:38:45",
    "userStatus": 14
  },
  "idleId": 835,
  "idleItem": {
    "id": 568,
    "idleName": "marcelene.friesen",
    "idleDetails": "pjuedx",
    "pictureList": "007uat",
    "idlePrice": 666,
    "idlePlace": "qbjqak",
    "idleLabel": 719,
    "releaseTime": "2024-06-22 08:38:45",
    "idleStatus": 17,
    "userId": 931,
    "user": {
      "id": 825,
      "accountNumber": "r8wsht",
      "userPassword": "rrl5l1",
      "nickname": "fannie.kris",
      "avatar": "1rrsfm",
      "signInTime": "2024-06-22 08:38:45",
      "userStatus": 19
    }
  },
  "orderPrice": 861,
  "paymentStatus": 18,
  "paymentWay": "ldjnbe",
  "createTime": "2024-06-22 08:38:45",
  "paymentTime": "2024-06-22 08:38:45",
  "orderStatus": 65,
  "isDeleted": 26
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
  "status_code": 896,
  "msg": "8fkj6d",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/order/my`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
shUserId|string|No comments found.|true|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/order/my?shUserId=163
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
  "status_code": 854,
  "msg": "fqkmi1",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/order/my-sold`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
shUserId|string|No comments found.|true|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/order/my-sold?shUserId=163
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
  "status_code": 396,
  "msg": "7ee2lv",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

