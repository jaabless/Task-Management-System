// Confirm before deleting a task
function confirmDelete(taskId) {
    if (confirm("Are you sure you want to delete this task?")) {
        window.location.href = "task?action=delete&id=" + taskId;
    }
}

// Optional: Update task status dynamically (AJAX placeholder)
function markAsCompleted(taskId) {
    alert("This feature can be extended to use AJAX to mark tasks as completed!");
}

// Optional: Client-side due date validation
document.addEventListener("DOMContentLoaded", function () {
    const dueDateInput = document.getElementById("dueDate");
    if (dueDateInput) {
        const today = new Date().toISOString().split("T")[0];
        dueDateInput.setAttribute("min", today);
    }
});


  let deleteUrl = '';

  function confirmDelete(id) {
    deleteUrl = 'task?action=delete&id=' + id;
    document.getElementById('confirmDialog').style.display = 'block';
  }

  function proceedDelete() {
    window.location.href = deleteUrl;
  }

  function closeDialog() {
    document.getElementById('confirmDialog').style.display = 'none';
  }
