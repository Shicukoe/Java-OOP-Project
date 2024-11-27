// Hiển thị thông báo
const showAlert = (content = null, time = 3000, type = "alert--success") => {
  if(content) {
    const newAlert = document.createElement("div");
    newAlert.setAttribute("class", `alert ${type}`);

    newAlert.innerHTML = `
      <span class="alert__content">${content}</span>
      <span class="alert__close">
        <i class="fa-solid fa-xmark"></i>
      </span>
    `;

    const alertList = document.querySelector(".alert-list");

    alertList.appendChild(newAlert);

    const alertClose = newAlert.querySelector(".alert__close");
  
    alertClose.addEventListener("click", () => {
      alertList.removeChild(newAlert);
    })
  
    setTimeout(() => {
      alertList.removeChild(newAlert);
    }, time)
  }
}
// Hết Hiển thị thông báo

// Bắt sự kiện cho phần xóa cuốn sách
const eventButtonDelete = () => {
  const listButtonDelete = document.querySelectorAll("[button-delete]");
  listButtonDelete.forEach(button => {
    button.addEventListener("click", () => {
      const id = button.getAttribute("button-delete");
      
      Swal.fire({
        name: "Are you sure to delete?",
        text: "This action cannot be reversed!",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Still Delete!",
        cancelButtonText: "No delete"
      }).then((result) => {
        if (result.isConfirmed) {
          axios.delete(`http://localhost:3000/pets/${id}`)
            .then(res => {
              const trDelete = document.querySelector(`tr[item-id="${id}"]`);
              if(trDelete) {
                trDelete.remove();
              }
              Swal.fire({
                name: "Deleted!",
                text: "This pet has been removed from the list.",
                icon: "success",
                timer: 3000
              });
            })
        }
      });
    })
  })
}
// Hết Bắt sự kiện cho phần xóa cuốn sách

const drawpetList = (keyword) => {
  let q = "";
  if(keyword) {
    q = `q=${keyword}`;
  }
  let linkApi = ` http://localhost:3000/pets?${q}`;
  axios.get(linkApi)
    .then(res => {
      let htmls = "";

      for (const item of res.data) {
        htmls += `
          <tr item-id="${item.id}">
            <td>${item.name}</td>
            <td>${item.price.toLocaleString()}đ</td>
            <td>${item.type}</td>
            <td>
              <a href="edit.html?id=${item.id}" class="button button-edit">Edit</a>
              <button class="button button-delete" button-delete="${item.id}">Delete</button>
            </td>
          </tr>
        `;
      }
      
      petList.innerHTML = htmls;
      eventButtonDelete();
    })
}

const petList = document.querySelector(".pet-list");
if(petList) {
  drawpetList();
}


const formSeach = document.querySelector(".form-search");
if(formSeach) {
  formSeach.addEventListener("submit", (event) => {
    event.preventDefault();
    const keyword = formSeach.keyword.value;
    drawpetList(keyword);
  })
}


const formCreate = document.querySelector("#form-create");
if(formCreate) {
  formCreate.addEventListener("submit", (event) => {
    event.preventDefault();

    const name = formCreate.name.value;
    const price = formCreate.price.value;
    const type = formCreate.type.value;

    if(!name) {
      showAlert("Please enter name!", 3000, "alert--error");
      return;
    }

    if(!price) {
      showAlert("Please enter price!", 3000, "alert--error");
      return;
    }

    if(!type) {
      showAlert("Please enter type!", 3000, "alert--error");
      return;
    }

    const data = {
      name: name,
      price: parseInt(price),
      type: type
    };

    axios.post("http://localhost:3000/pets", data)
      .then(res => {
        // Cách 1: In ra thông báo thành công, reset form về trắng tinh
        showAlert("Tạo sách thành công!");
        formCreate.reset();

        // Cách 2: Trở về trang danh sách
        // window.location.href = "index.html";
      })
  })
}

const formEdit = document.querySelector("#form-edit");
if(formEdit) {
  const params = new URL(window.location.href).searchParams;
  const id = params.get("id");
  axios.get(`http://localhost:3000/pets/${id}`)
    .then(res => {
      formEdit.name.value = res.data.name;
      formEdit.price.value = res.data.price;
      formEdit.type.value = res.data.type;

      formEdit.addEventListener("submit", (event) => {
        event.preventDefault();
    
        const name = formEdit.name.value;
        const price = formEdit.price.value;
        const type = formEdit.type.value;
    
        if(!name) {
          showAlert("Please enter name!", 3000, "alert--error");
          return;
        }
    
        if(!price) {
          showAlert("Please enter price!", 3000, "alert--error");
          return;
        }
    
        if(!type) {
          showAlert("Please enter type!", 3000, "alert--error");
          return;
        }
    
        const data = {
          name: name,
          price: parseInt(price),
          type: type
        };
    
        axios.patch(`http://localhost:3000/pets/${id}`, data)
          .then(res => {
            // Cách 1: In ra thông báo thành công
            showAlert("update success!");
    
            // Cách 2: Trở về trang danh sách
            // window.location.href = "index.html";
          })
      })
    })
}