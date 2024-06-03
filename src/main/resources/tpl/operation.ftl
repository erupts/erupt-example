<style>
    * {
        padding: 0;
        margin: 0;
    }

    td {
        padding: 8px;
    }
</style>
<div class="card">
    <table border="border" style="border: 1px;width: 100%;">
        <#list rows as row>
            <tr>
                <td>${row.id}</td>
                <td style="background: ${row.color!''}">${row.id!''}</td>
                <td>${row.code!''}</td>
            </tr>
        </#list>
    </table>
</div>