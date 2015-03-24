function save(application) {
    var applicationString = JSON.stringify(application);
    jQuery.post("/application/", {application: applicationString}, loadApplication);
}

function loadThisApplication() {
    return loadApplication(this.href);
}

function loadApplication(url) {
    jQuery.get(url, handleResponse);
    return false;
}

function handleResponse(applicationString) {
    var applicationPage = JSON.parse(applicationString);
    var application = applicationPage.application;
    jQuery("#actions button").show().each(function() {
        var nextState = jQuery(this).attr('class').toUpperCase();
        if (jQuery.inArray(nextState, applicationPage.possibleActions) === -1) {
            jQuery(this).hide()
        }
    });
    jQuery("#list").hide()
    jQuery("#application").show()
    jQuery("#idApplication").val(application.id)
    jQuery("#name").val(application.name)
    jQuery("#state").text(application.state)
    jQuery("#content").text(application.content)
}

function takeAction() {
    var newState = jQuery(this).attr('class').toUpperCase();
    var id = jQuery("#idApplication").val()
    
    jQuery.post("/application/" + id, {action: newState}, handleResponse);
    
}