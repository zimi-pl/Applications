
jQuery(function() {
    jQuery('body').on('click', '#pager a.current', false);
    jQuery('body').on('click', '#pager a.other', loadThisList);
    jQuery('body').on('click', 'a.application', loadThisApplication);
    
    jQuery('body').on('click', '#actions button', takeAction);
    
    loadList("/page/1")
    
    
})