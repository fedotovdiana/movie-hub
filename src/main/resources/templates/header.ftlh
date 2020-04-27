<#macro header>
    <#import "spring.ftl" as spring />

    <div class="header d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 border-bottom shadow-sm ">
        <h1 class=" my-0 mr-md-auto font-weight-normal"><@spring.message 'header.filmoteka'/></h1>
        <nav class="my-2 my-md-0 mr-md-3">
            <a class="p-2" href="/chat"><@spring.message 'chat.page'/></a>
            <a class="p-2" href="/afisha"><@spring.message 'header.afisha'/></a>
            <a class="p-2" href="/films"><@spring.message 'header.films'/></a>
            <a class="p-2" href="/top"><@spring.message 'header.top'/></a>
            <a class="p-2" href="/actors"><@spring.message 'header.actors'/></a>
            <a class="p-2" href="/producers"><@spring.message 'header.producers'/></a>
            <a class="p-2" href="/scriptwriters"><@spring.message 'header.scriptwriters'/></a>
        </nav>
        <a href="/profile"> <img src="/svg/person.svg" class="icon" alt="person"></a>
    </div>
</#macro>