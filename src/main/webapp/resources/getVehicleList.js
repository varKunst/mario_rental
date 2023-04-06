function getVnCode() {
  const vnCode = document.getElementById('vnCode');
  const vCode = document.getElementById('vCode');
  sessionStorage.setItem('vnCode', vnCode);
}