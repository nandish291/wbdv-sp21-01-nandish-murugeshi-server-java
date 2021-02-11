var usernameFld;
var passwordFld;
var firstNameFld;
var lastNameFld;
var roleFld;
var create;
var edit;
var remove;
var update;
var theTableBody;


var userService= new UserServiceClient();

var users = [];

function addUser() {
    createUser({
        userName: 'Jodoe',
        password: "*****",
        firstName: 'John',
        lastName: 'Doe',
        role: 'Faculty'
    })
}

function createUser(user) {
    userService.createUser(user)
        .then( (actualuser) => {
            users.push(actualuser)
            renderUsers(users)
            usernameFld.val("");
            passwordFld.val("");
            firstNameFld.val("")
            lastNameFld.val("");
            roleFld.val("Faculty")
        })
}

var selectedUser = null
function selectUser(event) {
    var selectBtn = jQuery(event.target);
    var theId = selectBtn.attr("id");
    selectedUser = users.find(user => user._id === theId);
    usernameFld.val(selectedUser.userName);
    passwordFld.val(selectedUser.password);
    firstNameFld.val(selectedUser.firstName);
    lastNameFld.val(selectedUser.lastName);
    roleFld.val(selectedUser.role);
}

function deleteUser(event) {
    console.log(event.target)
    var deleteBtn = jQuery(event.target)
    var theClass = deleteBtn.attr("class")
    var theIndex = deleteBtn.attr("id")
    var theId = users[theIndex]._id
    console.log(theClass)
    console.log(theIndex)

    userService.deleteUser(theId)
        .then(function () {
            users.splice(theIndex, 1)
            renderUsers(users)
        })
}

function renderUsers(users) {
    theTableBody.empty();
    for (var i = 0; i < users.length; i++) {
        var user = users[i]
        theTableBody
            .prepend(`
    <tr>
        <td>${user.username}</td>
        <td>*******</td>
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
        <td>${user.role}</td>
        <td><span class="pull-right">
          <i id="${i}" class="fa-2x fa fa-times wbdv-delete"></i>
          <i id="${user._id}" class="fa-2x far fa-edit wbdv-select"></i>
        </span>
        </td>
    </tr>
  `)
    }
    $(".wbdv-delete")
        .click(deleteUser)
    $(".wbdv-select")
        .click(selectUser)
}

function updateUser() {
    console.log(selectedUser)
    selectedUser.userName = usernameFld.val();
    selectedUser.password = passwordFld.val();
    selectedUser.firstName = firstNameFld.val();
    selectedUser.lastName=lastNameFld.val();
    selectedUser.role=roleFld.val();
    userService.updateUser(selectedUser._id, selectedUser)
        .then(function () {
            var index = users.findIndex(user => user._id === selectedUser._id);
            users[index] = selectedUser;
            renderUsers(users);
            usernameFld.val("");
            passwordFld.val("");
            firstNameFld.val("")
            lastNameFld.val("");
            roleFld.val("Faculty")
        })
}

function init() {

}
init();

$(document).ready(function(){
    usernameFld=$(".wbdv-usernameFld");
    passwordFld=$(".wbdv-passwordFld");
    firstNameFld=$(".wbdv-firstNameFld");
    lastNameFld=$(".wbdv-lastNameFld");
    roleFld=$(".wbdv-roleFld");
    create=$(".wbdv-createBtn");
    edit=$(".wbdv-edit");
    remove=$(".wbdv-remove");
    update=$(".wbdv-updateBtn");
    theTableBody = $("tbody");

    update.click(()=>updateUser())
    create.click(() => {
            createUser({
                username: usernameFld.val(),
                password: passwordFld.val(),
                firstName: firstNameFld.val(),
                lastName: lastNameFld.val(),
                role: roleFld.val()
            })
        }
    )

    userService.findAllUsers()
        .then( (actualUsersFromServer) => {
            users = actualUsersFromServer
            renderUsers(users)
        })
});