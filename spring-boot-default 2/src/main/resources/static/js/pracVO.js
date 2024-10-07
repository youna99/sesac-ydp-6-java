function submitForm() {
    const form = document.getElementById('pracVO');
        const interests = Array.from(form.querySelectorAll('input[name="interest"]:checked'))
                               .map(checkbox => checkbox.value);
    axios
        .post('/prac/axios/vo', {
            name: form.name.value,
            gender: form.gender.value,
            birth: form.birth.value,
            interest: interests
        })
        .then((res) => {
            console.log(`${res.data} 회원가입 성공`);
        });
}