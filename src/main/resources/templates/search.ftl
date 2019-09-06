<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>电影搜索</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/common.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery_lazyload/1.9.7/jquery.lazyload.min.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
    <style>
        em{
            color: orangered;
        }
        form{
            max-width: 280px;
            max-width: calc(100% - 100px);
        }
    </style>
</head>
<body class="container">
<header>
    <h1><a href="/">豆瓣电影搜索</a></h1>
    <form action="/s" class="input-group">
        <input name="wd" class="form-control" value='${wd}'>
        <div class="input-group-btn">
            <button type="submit" class="btn btn-primary">搜索</button>
        </div>
    </form>
</header>
    <#if page??>
    <section>
        <p>共找到相关结果${page.total}个，耗时${page.took}ms</p>
    </section>
    <section>
        <#list page.list as movie>
            <div>
                <p>
                    <a href="/detail/${movie.id}">
                        ${movie.title!""}
                    </a>
                </p>
                <p><img
                        src = "https://img3.doubanio.com/f/movie/03d3c900d2a79a15dc1295154d5293a2d5ebd792/pics/movie/tv_default_large.png"
                    <#if movie.cover_url??>data-original="${movie.cover_url}"</#if>
                        class="img-thumbnail lazy"
                        onerror="notFound()"
                >
                </p>
                <p>豆瓣评分：${movie.score}</p>
                <p>主演:[${movie.actor_count}]<#if movie.actors??><#list movie.actors as tn>/${tn}</#list></#if></p>
                <p>类型: <#if movie.types??><#list movie.types as tn>/${tn}</#list></#if></p>
                <p>制片国家/地区: <#if movie.regions??><#list movie.regions as tn>/${tn}</#list></#if></p>
                <p>上映日期: ${movie.release_date}</p>
                <p>${movie.vote_count}人评价</p>
                <p>暂无简介</p>
            </div>
        </#list>
    </section>
    <nav aria-label="...">
        <ul class="pager">
            <li class="previous<#if !page.hasPrevious()> disabled</#if>">
                <a href=<#if page.hasPrevious()>"/s?wd=${wd}&pn=${page.pageNo - 1}"<#else>#</#if>><span aria-hidden="true">&larr;</span> 上一页</a>
            </li>
            <li class="next<#if !page.hasNext()> disabled</#if>" >
                <a href=<#if page.hasNext()>"/s?wd=${wd}&pn=${page.pageNo + 1}"<#else>#</#if>>下一页 <span aria-hidden="true">&rarr;</span></a>
            </li>
        </ul>
    </nav>
    </#if>
<script>
    $("img.lazy").lazyload();
</script>
</body>
</html>