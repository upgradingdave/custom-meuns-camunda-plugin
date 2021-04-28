function menuAnchorTemplate(menuItem) {
    return '<a onclick="' + (menuItem.onclick ? menuItem.onclick : '') + '" href="' + (menuItem.url ? menuItem.url : '#') + '">'+ (menuItem.display ? menuItem.display : '') +'</a>';
}

function replaceLogout(menuItem) {
    let logoutHtml = '<li class="logout">'+menuAnchorTemplate(menuItem)+'</li>';
    let logoutEl = $('.logout');
    console.log(logoutHtml);
    logoutEl.replaceWith(logoutHtml);
}

function addMenuItem(menuItem) {
    let menuItemHtml = '<li>'+menuAnchorTemplate(menuItem)+'</li>';
    let appLinksEl = $('.app-switch .dropdown-menu');
    console.log(menuItemHtml);
    appLinksEl.append(menuItemHtml);
}

function customizeMenus(menuItems) {
    for(let k in menuItems) {
        if(k === 'logout') {
            replaceLogout(menuItems[k]);
        } else if (k === 'links') {
            for(let j in menuItems[k]) {
                addMenuItem(menuItems[k][j]);
            }
        }
    }
}

function loadCustomMenus() {
    return $.ajax({
        type : "GET",
        url : '/camunda/api/tasklist/plugin/custom-menu-tasklist/menuItems',
        dataType : 'json',
        timeout : 2000
    }).then(function(data) {
        console.log(data);
        customizeMenus(data);
    }).catch(function(e){
        //console.log(e);
    });
}

export default {
    id: "custom-menu-tasklist",
    pluginPoint: "tasklist.navbar.action",
    priority: 10,
    render: (node, { api }) => {
        loadCustomMenus();
    },
    unmount: () => {},
};