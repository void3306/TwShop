
# 
## 
**URL:** `http://localhost:9321/file`

**Type:** `POST`


**Content-Type:** `multipart/form-data`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
multipartFile|file|No comments found.|true|-


**Request-example:**
```
curl -X POST -H 'Content-Type: multipart/form-data' -i http://localhost:9321/file
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
  "status_code": 913,
  "msg": "v8di88",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/image`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
imageName|string|No comments found.|true|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/image?imageName=marcelene.friesen
```

**Response-example:**
```
Return void.
```

