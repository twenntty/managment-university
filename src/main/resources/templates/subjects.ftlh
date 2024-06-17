<h1>Предмети</h1>
    <h2>Додати новий предмет</h2>
    <form action="/subjects" method="post">
        <div>
            <label for="name">Назва:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div>
            <label for="description">Опис:</label>
            <textarea id="description" name="description" required></textarea>
        </div>
        <button type="submit">Додати</button>
    </form>

    <h2>Список предметів</h2>
    <ul>
        <#list subjects as subject>
            <li>${subject.name} - ${subject.description}</li>
        </#list>
    </ul>

    <a href="/departments">Повернутися до списку кафедр</a>
