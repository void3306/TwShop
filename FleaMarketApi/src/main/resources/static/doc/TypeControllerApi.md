
# 
## 
**URL:** `http://localhost:9321/type/listByCondition`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
begin|int32|No comments found.|false|-
size|int32|No comments found.|false|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/type/listByCondition?begin=873&size=10
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
  "status_code": 308,
  "msg": "iykffy",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

