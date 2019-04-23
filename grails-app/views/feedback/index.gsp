<!doctype html>
<html>
<head>
    <%-- layout is just another html page that gets injected into this page,
    in our case the main page that you just edited earlier --%>
    <meta name="layout" content="main">
    <g:set var="entityName" value="Feedback Form"/>
    <title>Feedback Form</title>
</head>

<body>
<div class="nav" role="navigation">
    <ul>
        <%-- this is our home button on the page --%>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>

    </ul>
</div>

<%-- this is our feedback form that like a text that needs to be displayed it's render
the "_" identifies the form and this is the way that a form is recognized --%>
<div id="create-feedbackForm" class="content scaffold-create" role="main">
    <h1><g:message code="Feedback Form"/></h1>
    <g:form action="index">
        <fieldset class="form">
            <g:render template="form"/>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="index" class="save" value="Submit"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
