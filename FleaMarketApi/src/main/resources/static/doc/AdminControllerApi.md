
# 
## 
**URL:** `http://localhost:9321/admin/login`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
accountNumber|string|No comments found.|true|-
adminPassword|string|No comments found.|true|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/admin/login?adminPassword=s69mrm&accountNumber=ckurya
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
  "status_code": 169,
  "msg": "ugx37f",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/admin/loginOut`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 





**Request-example:**
```
curl -X GET -i http://localhost:9321/admin/loginOut
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
  "status_code": 888,
  "msg": "iuhx3n",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/admin/list`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
page|int32|No comments found.|false|-
nums|int32|No comments found.|false|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/admin/list?page=1&nums=388
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
  "status_code": 322,
  "msg": "wfea3s",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/admin/add`

**Type:** `POST`


**Content-Type:** `application/json; charset=utf-8`

**Description:** 




**Body-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
id|int64|自增主键|false|-
accountNumber|string|管理员账号|false|-
adminPassword|string|密码|false|-
adminName|string|管理员名字|false|-

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json; charset=utf-8' -i http://localhost:9321/admin/add --data '{
  "id": 498,
  "accountNumber": "wrse3h",
  "adminPassword": "nxt18h",
  "adminName": "marcelene.friesen"
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
  "status_code": 737,
  "msg": "mxvki6",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/admin/idleList`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
status|int32|No comments found.|true|-
page|int32|No comments found.|false|-
nums|int32|No comments found.|false|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/admin/idleList?page=1&nums=856&status=93
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
  "status_code": 536,
  "msg": "2s8pgc",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/admin/updateIdleStatus`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
id|int64|No comments found.|true|-
status|int32|No comments found.|true|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/admin/updateIdleStatus?id=727&status=618
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
  "status_code": 951,
  "msg": "974b8b",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/admin/orderList`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
page|int32|No comments found.|false|-
nums|int32|No comments found.|false|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/admin/orderList?nums=310&page=1
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
  "status_code": 390,
  "msg": "zbi8h2",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/admin/deleteOrder`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
id|int64|No comments found.|true|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/admin/deleteOrder?id=400
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
  "status_code": 251,
  "msg": "kkvtkt",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/admin/userList`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
page|int32|No comments found.|false|-
nums|int32|No comments found.|false|-
status|int32|No comments found.|true|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/admin/userList?status=929&page=1&nums=465
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
  "status_code": 66,
  "msg": "juphhs",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/admin/updateUserStatus`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
id|int64|No comments found.|true|-
status|int32|No comments found.|true|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/admin/updateUserStatus?id=408&status=872
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
  "status_code": 114,
  "msg": "w9px3v",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

