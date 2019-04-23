<!doctype html>
<html>

<head>
    <title>Kiosk</title>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.min.css')}" type="text/css">
    <asset:javascript src="respond.js"/>
</head>

<body>
<g:form url="[resource: customer, action: 'customerLookup']">
    <g:render template="kioskForm"/>
</g:form>


<g:javascript library="jquery"/>
<asset:javascript src="bootstrap.min.js"/>
</body>
</html>