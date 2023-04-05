function checkValues(htmlForm) {
  const command = document.getElementById('command').value;
  const id = document.getElementById('id').value;
  const password = document.getElementById('password').value;

  let check = true;
  let url = 'logIn?';
  let name = null;
  if(command==="join") {
    name = document.getElementById('name').value
    url = 'join?';
  }

  if(id!=="") {
    url += "&id=" + id;
  }
  if(command==="join" && name!=="") {
    url += "&name=" + name;
  }

  if(id==="") {
    alert("아이디를 입력해주세요.");
    check = false;
  } else if(password==="") {
    alert("비밀번호를 입력해주세요.");
    check = false;
  } else if(command==="join" && name==="") {
    alert("이름을 입력해주세요.");
    check = false;
  }

  if(!check) {
    location.href = url;
  } else {
    htmlForm.submit();
  }
}