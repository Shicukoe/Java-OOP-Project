import { initializeApp } from "https://www.gstatic.com/firebasejs/10.14.1/firebase-app.js";
import { getDatabase, ref, push, set, onValue, update, remove } from "https://www.gstatic.com/firebasejs/10.14.1/firebase-database.js";
import { getAuth, createUserWithEmailAndPassword, signInWithEmailAndPassword, signOut, onAuthStateChanged, GoogleAuthProvider, signInWithPopup, sendPasswordResetEmail } from "https://www.gstatic.com/firebasejs/10.14.1/firebase-auth.js";

const firebaseConfig = {
  apiKey: "AIzaSyCEOUZ_FGwIbHrlH4pNr_3jHKRgQZUAjkw",
  authDomain: "my-project-ffc6d.firebaseapp.com",
  databaseURL: "https://my-project-ffc6d-default-rtdb.firebaseio.com",
  projectId: "my-project-ffc6d",
  storageBucket: "my-project-ffc6d.appspot.com",
  messagingSenderId: "447570199636",
  appId: "1:447570199636:web:f6d92c959472bc807e59c1",
  measurementId: "G-GQEEJWFPT2"
};

const app = initializeApp(firebaseConfig);
const db = getDatabase();
const auth = getAuth(app);
let userCurrent = null;
const todosRef = ref(db, 'todos');

// Display notification
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
// End Display notification

// form-register
const formRegister = document.querySelector("#form-register");
if(formRegister) {
  formRegister.addEventListener("submit", (event) => {
    event.preventDefault();

    const email = formRegister.email.value;
    const password = formRegister.password.value;

    if(email && password) {
      createUserWithEmailAndPassword(auth, email, password)
        .then((userCredential) => {
          // Signed up 
          const user = userCredential.user;
          if(user) {
            window.location.href = "index.html";
          }
        })
        .catch((error) => {
          const errorCode = error.code;
          const errorMessage = error.message;
          showAlert("Email already exists in the system!", 5000, "alert--error");
        });
    }
  })
}
// End form-register

// form-login
// const formLogin = document.querySelector("#form-login");
// if(formLogin) {
//   formLogin.addEventListener("submit", (event) => {
//     event.preventDefault();

//     const email = formLogin.email.value;
//     const password = formLogin.password.value;

//     if(email && password) {
//       signInWithEmailAndPassword(auth, email, password)
//         .then((userCredential) => {
//           // Logged in 
//           const user = userCredential.user;
//           if(user) {
//             window.location.href = "index.html";
//           }
//         })
//         .catch((error) => {
//           const errorCode = error.code;
//           const errorMessage = error.message;
//           showAlert("Email or password is incorrect!", 5000, "alert--error");
//         });
//     }
//   })
// }
// End form-login

// button-logout
const buttonLogout = document.querySelector("[button-logout]");
if(buttonLogout) {
  buttonLogout.addEventListener("click", () => {
    signOut(auth).then(() => {
      // Sign-out successful.
      window.location.href = "login.html";
    }).catch((error) => {
      // An error happened.
    });    
  })
}

const buttonMangePage = document.querySelector("[button-mangepage]");
if(buttonMangePage) {
  buttonMangePage.addEventListener("click", () => {
    // Replace the following line with an async operation, if needed.
    Promise.resolve()
      .then(() => {
        window.location.href = "managepage.html";
      })
      .catch((error) => {
        console.error("An error happened:", error);
      });
  });
}

// End button-logout

// Check login status
// const buttonLogin = document.querySelector("[button-login]");
const buttonRegister = document.querySelector("[button-register]");
const todoApp = document.querySelector(".todo-app");

onAuthStateChanged(auth, (user) => {
  if (user) {
    // console.log(user.email);
    userCurrent = user;
    buttonLogout.style.display = "inline";
    todoApp.style.display = "block";
  } else {
    // buttonLogin.style.display = "inline";
    buttonRegister.style.display = "inline";
    if(todoApp) {
      todoApp.remove();
    }
  }
});
// End Check login status

const closeModal = (element) => {
  const body = document.querySelector("body");

  const modalClose = element.querySelector(".modal__close");
  const buttonClose = element.querySelector(".button__close");
  const modalOverlay = element.querySelector(".modal__overlay");

  modalClose.addEventListener("click", () => {
    body.removeChild(element);
  })

  buttonClose.addEventListener("click", () => {
    body.removeChild(element);
  })

  modalOverlay.addEventListener("click", () => {
    body.removeChild(element);
  })
}

// Display confirmation
const showConfirmDelete = (id) => {
  const body = document.querySelector("body");

  const elementConfirm = document.createElement("div");
  elementConfirm.classList.add("modal");

  elementConfirm.innerHTML = `
    <div class="modal__main">
      <button class="modal__close">
        <i class="fa-solid fa-xmark"></i>
      </button>
      <div class="modal__content">
        <div class="modal__text">
          Are you sure you want to delete this task?
        </div>
        <button class="button__close">Cancel</button>
        <button class="button__agree">Agree</button>
      </div>
    </div>
    <div class="modal__overlay"></div>
  `;

  body.appendChild(elementConfirm);

  closeModal(elementConfirm);

  const buttonAgree = elementConfirm.querySelector(".button__agree");
  buttonAgree.addEventListener("click", () => {
    remove(ref(db, '/todos/' + id)).then(() => {
      body.removeChild(elementConfirm);
      showAlert("Deleted successfully!", 5000);
    });
  });
}
// End Display confirmation

// showFormEdit
const showFormEdit = (id) => {
  const body = document.querySelector("body");

  const elementEdit = document.createElement("div");
  elementEdit.classList.add("modal");

  elementEdit.innerHTML = `
    <div class="modal__main">
      <button class="modal__close">
        <i class="fa-solid fa-xmark"></i>
      </button>
      <div class="modal__content">
        <div class="modal__text">
          Edit task
        </div>
        <input name="content" />
        <button class="button__close">Cancel</button>
        <button class="button__agree">Update</button>
      </div>
    </div>
    <div class="modal__overlay"></div>
  `;

  body.appendChild(elementEdit);

  closeModal(elementEdit);

  const buttonAgree = elementEdit.querySelector(".button__agree");
  buttonAgree.addEventListener("click", () => {
    const content = elementEdit.querySelector("input[name='content']").value;
    if(content) {
      const dataUpdate = {
        content: content
      };
      body.removeChild(elementEdit);
      showAlert("Updated successfully!", 3000);
      update(ref(db, '/todos/' + id), dataUpdate);
    }
  });

  onValue(ref(db, '/todos/' + id), (item) => {
    const data = item.val();
    elementEdit.querySelector("input[name='content']").value = data.content;
  })
}
// End showFormEdit

// Add task
const todoAppCreate = document.querySelector("#todo-app-create");
if(todoAppCreate) {
  todoAppCreate.addEventListener("submit", (event) => {
    event.preventDefault();

    const content = todoAppCreate.content.value;
    if(content) {
      const data = {
        content: content,
        complete: false,
        uid: userCurrent.uid
      };
    
      const newTodoRef = push(todosRef);
      set(newTodoRef, data).then(() => {
        showAlert("Created successfully!", 3000);
      });

      todoAppCreate.content.value = "";
    }
  })
}
// End Add task

// Fetch task list
const todoAppList = document.querySelector("#todo-app-list");
if(todoAppList) {
  onValue(todosRef, (items) => {
    const htmls = [];
  
    items.forEach((item) => {
      const key = item.key;
      const data = item.val();
  
      let buttonComplete = "";
  
      if(!data.complete) {
        buttonComplete = `
          <button 
            class="todo-app__item-button todo-app__item-button--complete"
            button-complete="${key}"
          >
            <i class="fa-solid fa-check"></i>
          </button>
        `;
      } else {
        buttonComplete = `
          <button 
            class="todo-app__item-button todo-app__item-button--undo"
            button-undo="${key}"
          >
            <i class="fa-solid fa-rotate-left"></i>
          </button>
        `;
      }
  
      htmls.push(`
        <div class="todo-app__item">
          <div class="todo-app__item-content ${data.complete ? "todo-app__item-content--complete" : ""}">
            ${data.content}
          </div>
          ${buttonComplete}
          <button 
            class="todo-app__item-button todo-app__item-button--edit"
            button-edit="${key}"
          >
            <i class="fa-solid fa-pen-to-square"></i>
          </button>
          <button 
            class="todo-app__item-button todo-app__item-button--delete"
            button-delete="${key}"
          >
            <i class="fa-solid fa-trash"></i>
          </button>
        </div>
      `);
    });
  
    todoAppList.innerHTML = htmls.join("");

    const buttonCompletes = document.querySelectorAll("[button-complete]");
    buttonCompletes.forEach((button) => {
      button.addEventListener("click", (event) => {
        const id = button.getAttribute("button-complete");
        const dataUpdate = {
          complete: true
        };
        update(ref(db, '/todos/' + id), dataUpdate);
      })
    })

    const buttonUndos = document.querySelectorAll("[button-undo]");
    buttonUndos.forEach((button) => {
      button.addEventListener("click", (event) => {
        const id = button.getAttribute("button-undo");
        const dataUpdate = {
          complete: false
        };
        update(ref(db, '/todos/' + id), dataUpdate);
      })
    })

    const buttonDeletes = document.querySelectorAll("[button-delete]");
    buttonDeletes.forEach((button) => {
      button.addEventListener("click", (event) => {
        const id = button.getAttribute("button-delete");
        showConfirmDelete(id);
      })
    })

    const buttonEdits = document.querySelectorAll("[button-edit]");
    buttonEdits.forEach((button) => {
      button.addEventListener("click", (event) => {
        const id = button.getAttribute("button-edit");
        showFormEdit(id);
      })
    })
  })
}
// End Fetch task list

// Form Reset Password
const formResetPassword = document.querySelector("#form-reset-password");
if(formResetPassword) {
  formResetPassword.addEventListener("submit", (event) => {
    event.preventDefault();

    const email = formResetPassword.email.value;

    if(email) {
      sendPasswordResetEmail(auth, email)
        .then(() => {
          showAlert("Please check your email", 5000);
        })
        .catch((error) => {
          const errorCode = error.code;
          const errorMessage = error.message;
          showAlert("Email does not exist in the system", 5000, "alert--error");
        });
    }
  })
}
// End Form Reset Password

// Login with google
const buttonLoginGoogle = document.querySelector("[button-login-google]");
if(buttonLoginGoogle) {
  buttonLoginGoogle.addEventListener("click", (event) => {
    const provider = new GoogleAuthProvider();
    signInWithPopup(auth, provider)
      .then((result) => {
        // The signed-in user info.
        const user = result.user;
        if(user) {
          window.location.href = "index.html";
        }
      }).catch((error) => {
        const errorCode = error.code;
        const errorMessage = error.message;
      });
  })
}
// End Login with google
