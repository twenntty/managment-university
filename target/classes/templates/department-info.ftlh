<h1>Деталі кафедри</h1>
<div>
    <strong>Назва:</strong> ${department.name}<br>
    <strong>Title:</strong> ${department.title}<br>
    <strong>Телефон:</strong> ${department.phone}<br>
    <strong>Аудиторія:</strong> ${department.classroom}
</div>
<div>
    <a href="/departments">Повернутись до списку кафедр</a>
</div>
<h2>Додати предмети до кафедри</h2>
<form action="/departments/${department.id}" method="post">
    <select name="subjectIds" multiple>
        <#list allSubjects as subject>
            <option value="${subject.id}">${subject.name}</option>
        </#list>
    </select>
    <button type="submit">Додати вибрані предмети</button>
</form>

<!-- Відображення доданих предметів -->
<h2>Предмети кафедри</h2>
<#if department.subjects??>
    <ul>
        <#list department.subjects as subject>
            <li>${subject.name} - ${subject.description}</li>
        </#list>
    </ul>
<#else>
    <p>Наразі до кафедри не додано жодних предметів.</p>
</#if>

<div>
    <a href="/departments">Повернутись до списку кафедр</a>
</div>
