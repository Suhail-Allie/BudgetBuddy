const menu=document.querySelector('.menu');const links=document.querySelector('.navlinks');if(menu)menu.addEventListener('click',()=>links.classList.toggle('open'));
document.querySelectorAll('[data-demo-login]').forEach(b=>b.addEventListener('click',e=>{e.preventDefault();alert('Demo login successful. Opening dashboard.');location.href='dashboard.html'}));
document.querySelectorAll('[data-demo-action]').forEach(b=>b.addEventListener('click',()=>alert('Demo action completed successfully.')));
