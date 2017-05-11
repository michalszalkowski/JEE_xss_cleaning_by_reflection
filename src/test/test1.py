# python 3.4

import urllib.request
import urllib.parse
import json

newLeg = {
    "name": "<h1>michal <small>michal</small></h1>",
    "surname": "<h2>szalek</h2>",
    "address": {
        "street": "<b>Curie Skłodowska <script>alert(1)</script></b>"
    },
    "addressDtos": [
        {"street": "<h1>test</h1>"},
        {"street": "<h2>test</h2>"},
        {"street": "<h3>test</h3>"},
        {"street": "<h4>test</h4>"}
    ]
}

params = json.dumps(newLeg).encode('utf8')

_headers = {
    'Content-Type': 'application/json;charset=UTF-8'
}

req = urllib.request.Request(
    'http://localhost:8080/xss_cleaning_by_reflection/rest/person',
    data=params,
    headers=_headers,
    method='POST'
)

response = urllib.request.urlopen(req)

print(str(response.read()))
