for (let e of document.querySelectorAll("button[id*='marsApi']")) {
	e.addEventListener('click', function() {
		const buttonId = this.id
		const roverId = buttonId.split('marsApi')[1]
		let apiData = document.getElementById('marsApiRoverData')
		apiData.value = roverId
		document.getElementById('frmRoverType').submit()
	});
}