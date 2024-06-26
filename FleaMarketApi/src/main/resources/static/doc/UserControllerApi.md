
# 
## 注册账号
**URL:** `http://localhost:9321/user/sign-in`

**Type:** `POST`


**Content-Type:** `application/json; charset=utf-8`

**Description:** 注册账号




**Body-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
id|int64|自增主键|false|-
accountNumber|string|账号（手机号）|false|-
userPassword|string|登录密码|false|-
nickname|string|昵称|false|-
avatar|string|头像|false|-
signInTime|string|注册时间|false|-
userStatus|int8|No comments found.|false|-

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json; charset=utf-8' -i http://localhost:9321/user/sign-in --data '{
  "id": 73,
  "accountNumber": "c2drcw",
  "userPassword": "z4rlz3",
  "nickname": "fannie.kris",
  "avatar": "c6pqwc",
  "signInTime": "2024-06-22 08:38:46",
  "userStatus": 13
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
  "status_code": 994,
  "msg": "tb212d",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 
**URL:** `http://localhost:9321/user/captcha`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 





**Request-example:**
```
curl -X GET -i http://localhost:9321/user/captcha
```

**Response-example:**
```
{
  "mapKey1": "qlvj4f",
  "mapKey2": "vi1wmz"
}
```

## 登录，不安全，可伪造id，后期改进
**URL:** `http://localhost:9321/user/login`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 登录，不安全，可伪造id，后期改进



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
accountNumber|string|No comments found.|true|-
userPassword|string|No comments found.|true|-
code|string|No comments found.|true|-
token|string|No comments found.|true|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/user/login?userPassword=rsearv&accountNumber=cnopg9&token=cb2ezb&code=25400
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
  "status_code": 935,
  "msg": "04f49t",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 退出登录
**URL:** `http://localhost:9321/user/logout`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 退出登录



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
shUserId|string|No comments found.|true|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/user/logout?shUserId=163
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
  "status_code": 885,
  "msg": "e394vj",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 获取用户信息
**URL:** `http://localhost:9321/user/info`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 获取用户信息



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
id|string|No comments found.|true|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/user/info?id=163
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
  "status_code": 397,
  "msg": "mc0f7z",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 修改用户公开信息
**URL:** `http://localhost:9321/user/info`

**Type:** `POST`


**Content-Type:** `application/json; charset=utf-8`

**Description:** 修改用户公开信息



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
id|string|No comments found.|true|-

**Body-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
id|int64|自增主键|false|-
accountNumber|string|账号（手机号）|false|-
userPassword|string|登录密码|false|-
nickname|string|昵称|false|-
avatar|string|头像|false|-
signInTime|string|注册时间|false|-
userStatus|int8|No comments found.|false|-

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json; charset=utf-8' -i http://localhost:9321/user/info?id=163 --data '{
  "id": 572,
  "accountNumber": "z0rvfl",
  "userPassword": "kt7wcw",
  "nickname": "fannie.kris",
  "avatar": "izc90c",
  "signInTime": "2024-06-22 08:38:46",
  "userStatus": 28
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
  "status_code": 378,
  "msg": "e09qya",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

## 修改密码
**URL:** `http://localhost:9321/user/password`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 修改密码



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
id|string|No comments found.|true|-
oldPassword|string|No comments found.|true|-
newPassword|string|No comments found.|true|-


**Request-example:**
```
curl -X GET -i http://localhost:9321/user/password?id=163&oldPassword=sqm8cd&newPassword=dksi37
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
  "status_code": 746,
  "msg": "51q2ye",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```

