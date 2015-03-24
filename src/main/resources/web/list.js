function pager(pageString) {
    var page = JSON.parse(pageString);
    var links = '';
    for (var i = 1; i <= page.numberOfPages; i++) {
        var className = i === page.currentPage ? 'current' : 'other'; 
        links += '<a href="/page/' + i + '" class="' + className + '">' + i + '</a> ';
    }
    return links;
}

function table(pageString) {
    var page = JSON.parse(pageString);
    return jQuery.map(page.applications, function( val ) {
        return '<tr><td>' + val.name + '</td><td>' + val.content + '</td><td>' + val.state + '</td>'
                +'<td><a href="/application/' + val.id + '" class="application">Pokaż</a></td></tr>';
    }).join("");
}

function loadThisList() {
    return loadList(this.href)
}

function loadList(url) {
    jQuery.get(url, function (x) {
        jQuery("#list").show()
        jQuery("#application").hide();
        jQuery("#pager").html(pager(x));
        jQuery("tbody").html(table(x));
    })
    return false;
}
