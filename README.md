shrine

# Commons

## String format

Key         |  Value
------------|------------
Entrypoint  | lowerCamel
Key of json | lowerCamel

## DateTime Format

```
YYYY-MM-DDThh:mm:ssTZD
```

# Interfaces

## /accounts

口座。

### Response format

```
{
  "accountId"        : "{accountId}",
  "value"            : 0,
  "createdAt"        : "2001-08-02T10:45:23+09:00",
  "lastAddedAt"      : null,
  "lastSubtractedAt" : null
}
```

### POST /accounts

口座を新しく作成する。

```
{
  /* 口座開設に必要な情報 */
}
```

### GET /accounts/{accountId}

口座を参照する。

## /accounts/{accountId}/additions

加算。

### Response format

```
{
  "additionId" : "{additionId}",
  "value" : 10000,
  "description" : "Description ....",
  "sourceTransactionId" : "{sourceTransactionId}",
  "createdAt" : "2001-08-02T10:45:23+09:00",
  "executedAt" : null,
  "status" : "created",
  "causeCode" : "0000"
}
```

### POST /accounts/{accountId}/additions

加算を作成する。この時点ではまだ加算されない。

```
{
  "value" : 10000,
  "description" : "Description ....",
  "sourceTransactionId" : "{sourceTransactionId}"
}
```

### PUT /accounts/{accountId}/additions/{additionId}

加算を実行する。

```
```

### GET /accounts/{accountId}/additions

加算の一覧を参照する。

Key                 | Required
--------------------|----------
sourceTransactionId | 

### GET /accounts/{accountId}/additions/{additionId}

加算を参照する。

## /accounts/{accountId}/subtractions

減算。

### Response format

```
{
  "subtractionId" : "{subtractionId}",
  "value" : 10000,
  "description" : "Description ....",
  "destinationTransactionId" : "{destinationTransactionId}",
  "createdAt" : "2001-08-02T10:45:23+09:00",
  "executedAt" : null,
  "status" : "created",
  "causeCode" : "0000"
}
```

### POST /accounts/{accountId}/subtractions

減算を作成する。この時点ではまだ減算されない。

```
{
  "value" : 10000,
  "description" : "Description ....",
  "destinationTransactionId" : "{destinationTransactionId}"
}
```

### PUT /accounts/{accountId}/subtractions/{subtractionId}

減算を実行する。

```
```

### GET /accounts/{accountId}/subtractions

減算の一覧を参照する。

Key                      | Required
-------------------------|----------
destinationTransactionId | 

### GET /accounts/{accountId}/subtractions/{subtractionId}

減算を参照する。

## /accounts/{accountId}/transfers

移動。

### Response format

```
{
  "transferId" : "{transferId}",
  "value" : 10000,
  "description" : "Description ....",
  "destinationAccountId" : "{accountId}",
  "createdAt" : "2001-08-02T10:45:23+09:00",
  "executedAt" : null,
  "status" : "created",
  "causeCode" : "0000"
}
```

### POST /accounts/{accountId}/transfers

移動を作成する。この時点ではまだ移動されない。

```
{
  "value" : 10000,
  "description" : "Description ....",
  "destinationAccountId" : "{accountId}"
}
```


### PUT /accounts/{accountId}/transfers/{transferId}

valueを移動する取引を確定する。

# Codes

## Account Status

status     | description 
-----------|--------------------
active     |
inactive   |

## Transaction Status and causeCodes

status    | causeCode | Description   | addition | substraction | transfer
----------|-----------|---------------|----------|--------------|----------
created   | 0000      | Created.      | o        | o            | o
succeeded | 1000      | Succeeded.    | o        | o            | o
failed    | 9000      | Shortage.     | o        | o            | o
failed    | 9999      | System error. | o        | o            | o
