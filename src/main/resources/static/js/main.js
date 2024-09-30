let sliderIndex = 0;
showSlides();

function showSlides() {
    const slides = document.querySelectorAll('.slider-item');
    for (let i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    sliderIndex++;
    if (sliderIndex > slides.length) { sliderIndex = 1 }
    slides[sliderIndex - 1].style.display = "block";
    setTimeout(showSlides, 3000); // Change slide every 3 seconds
}