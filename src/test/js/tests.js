var json = '{"numberOfPages":2, "currentPage": 2, "applications":[{"id": 1, "name":"Wniosek o wydanie prawa jazdy","content":"W związku ze zdaniem prawa jazdy przeze mnie. Wnoszę o wydanie prawa jazdy na moje nazwisko.","state":"VERIFIED","previousStates":[{"state":"CREATED","date":"Mar 24, 2015 7:32:28 AM"},{"state":"VERIFIED","date":"Mar 24, 2015 7:32:28 AM"}]}]}';

QUnit.test( "pager", function( assert ) {
    var r = pager(json)
    var expected = '<a href="/page/1" class="other">1</a> <a href="/page/2" class="current">2</a> ';
    assert.equal( r, expected, "Passed!" );
});

QUnit.test( "table", function( assert ) {
    var r = table(json)
    var expected = '<tr><td>Wniosek o wydanie prawa jazdy</td>'
        + '<td>W związku ze zdaniem prawa jazdy przeze mnie. Wnoszę o wydanie prawa '
        + 'jazdy na moje nazwisko.</td><td>VERIFIED</td>'
        + '<td><a href="/application/1" class="application">Pokaż</a></td></tr>';
    assert.equal( r, expected, "Passed!" );
});