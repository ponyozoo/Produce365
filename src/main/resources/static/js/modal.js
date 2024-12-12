const newModal = document.getElementById('newModal');
const deleteModal = document.getElementById('deleteModal');

function openNewModal() {
	newModal.style.display = 'block';
}

function closeNewModal() {
	newModal.style.display = 'none';
}

function openDeleteModal(base, idx) {
	deleteModal.style.display = 'block';
	const button = document.getElementById('confirmDeleteButton');
	button.addEventListener('click', () => {
		location.href='/'+ base + '/delete?id=' + idx;
	})
}

function closeDeleteModal() {
	deleteModal.style.display = 'none';
}