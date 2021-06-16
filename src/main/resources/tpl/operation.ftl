<style>
    * {
        padding: 0;
        margin: 0;
    }
</style>
<div class="card" style="padding: 16px">
    <table border="border" style="border: 1px;width: 100%">
        <#list rows as row>
            <tr>
                <td>${row.id}</td>
                <td style="background: #09f">${row.choice!''}</td>
                <td>${row.code!''}</td>
            </tr>
        </#list>
    </table>
</div>