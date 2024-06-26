
# 
## 
**URL:** `http://localhost:9321/order-address/add`

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
id|int64|No comments found.|false|-
orderId|int64|No comments found.|false|-
consigneeName|string|No comments found.|false|-
consigneePhone|string|No comments found.|false|-
detailAddress|string|No comments found.|false|-

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json; charset=utf-8' -i http://localhost:9321/order-address/add?shUserId=163 --data '{
  "id": 610,
  "orderId": 198,
  "consigneeName": "marcelene.friesen",
  "consigneePhone": "401.937.1576",
  "detailAddress": "022 Merissa Oval， West Jewell， AZ 95608-6692"
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
  "status_code": 782,
  "msg": "w0l9hh",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/order-address/update`

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
id|int64|No comments found.|false|-
orderId|int64|No comments found.|false|-
consigneeName|string|No comments found.|false|-
consigneePhone|string|No comments found.|false|-
detailAddress|string|No comments found.|false|-

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json; charset=utf-8' -i http://localhost:9321/order-address/update?shUserId=163 --data '{
  "id": 790,
  "orderId": 678,
  "consigneeName": "marcelene.friesen",
  "consigneePhone": "401.937.1576",
  "detailAddress": "022 Merissa Oval， West Jewell， AZ 95608-6692"
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
  "status_code": 688,
  "msg": "f2dovh",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/order-address/info`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
shUserId|string|No comments found.|true|-
orderId|int64|No comments found.|true|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/order-address/info?orderId=235&shUserId=163
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
  "status_code": 523,
  "msg": "vbwsj2",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

