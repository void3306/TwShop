
# 
## 
**URL:** `http://localhost:9321/address/info`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
shUserId|string|No comments found.|true|-
id|int64|No comments found.|false|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/address/info?shUserId=163&id=800
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
  "status_code": 789,
  "msg": "cx9sb2",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/address/add`

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
consigneeName|string|收货人姓名|false|-
consigneePhone|string|收货人手机号|false|-
provinceName|string|省|false|-
cityName|string|市|false|-
regionName|string|区|false|-
detailAddress|string|详细地址|false|-
defaultFlag|boolean|是否默认地址|false|-
userId|int64|用户主键id|false|-

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json; charset=utf-8' -i http://localhost:9321/address/add?shUserId=163 --data '{
  "id": 475,
  "consigneeName": "marcelene.friesen",
  "consigneePhone": "401.937.1576",
  "provinceName": "marcelene.friesen",
  "cityName": "marcelene.friesen",
  "regionName": "marcelene.friesen",
  "detailAddress": "022 Merissa Oval， West Jewell， AZ 95608-6692",
  "defaultFlag": true,
  "userId": 232
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
  "status_code": 29,
  "msg": "idqnwv",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/address/update`

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
consigneeName|string|收货人姓名|false|-
consigneePhone|string|收货人手机号|false|-
provinceName|string|省|false|-
cityName|string|市|false|-
regionName|string|区|false|-
detailAddress|string|详细地址|false|-
defaultFlag|boolean|是否默认地址|false|-
userId|int64|用户主键id|false|-

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json; charset=utf-8' -i http://localhost:9321/address/update?shUserId=163 --data '{
  "id": 943,
  "consigneeName": "marcelene.friesen",
  "consigneePhone": "401.937.1576",
  "provinceName": "marcelene.friesen",
  "cityName": "marcelene.friesen",
  "regionName": "marcelene.friesen",
  "detailAddress": "022 Merissa Oval， West Jewell， AZ 95608-6692",
  "defaultFlag": true,
  "userId": 444
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
  "status_code": 294,
  "msg": "eq2bq1",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/address/delete`

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
consigneeName|string|收货人姓名|false|-
consigneePhone|string|收货人手机号|false|-
provinceName|string|省|false|-
cityName|string|市|false|-
regionName|string|区|false|-
detailAddress|string|详细地址|false|-
defaultFlag|boolean|是否默认地址|false|-
userId|int64|用户主键id|false|-

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json; charset=utf-8' -i http://localhost:9321/address/delete?shUserId=163 --data '{
  "id": 130,
  "consigneeName": "marcelene.friesen",
  "consigneePhone": "401.937.1576",
  "provinceName": "marcelene.friesen",
  "cityName": "marcelene.friesen",
  "regionName": "marcelene.friesen",
  "detailAddress": "022 Merissa Oval， West Jewell， AZ 95608-6692",
  "defaultFlag": true,
  "userId": 157
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
  "status_code": 125,
  "msg": "u7odhw",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

