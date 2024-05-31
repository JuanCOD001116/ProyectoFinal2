// Add event listener to taskbar links
document.querySelectorAll('.taskbar a').forEach(link => {
    link.addEventListener('click', event => {
        event.preventDefault();
        console.log(`Taskbar link clicked: ${link.textContent}`);
    });
});