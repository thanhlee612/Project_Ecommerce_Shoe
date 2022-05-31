function myFunction(pid, pname, pimage, price) {
	let cart = localStorage.getItem("cart");
	if (cart === null) {
		let products = [];
		let product = { product_id: pid, product_name: pname, product_image: pimage, product_quantity: 1, product_price: price };
		products.push(product);
		localStorage.setItem("cart", JSON.stringify(products));
		// console.log("product is added for the first time");
	} else {
		let pcart = JSON.parse(cart);
		let oldProduct = pcart.find((item) => item.product_id == pid);
		if (oldProduct) {
			oldProduct.product_quantity = oldProduct.product_quantity + 1;
			pcart.map((item) => {
				if (item.product_id == oldProduct.product_id) {
					item.product_quantity = oldProduct.product_quantity;
				}
			});
			localStorage.setItem("cart", JSON.stringify(pcart));
			//  console.log("product quantity increased");
		} else {
			let product = { product_id: pid, product_name: pname, product_image: pimage, product_quantity: 1, product_price: price };
			pcart.push(product);
			localStorage.setItem("cart", JSON.stringify(pcart));
			//  console.log("product is added");
		}
	}
	updateCart();
}

function updateCart() {
	let cartString = localStorage.getItem("cart");
	let cart = JSON.parse(cartString);
	if (cart == null || cart.length == 0) {
		console.log("cart is empty!");
		$(".cart-items").html("(0)");
		$(".cart-body").html("<h4>Cart does not have any items</h4>");
		$(".checkout-btn").attr('disabled', true);
	} else {
		console.log(cart);
		$(".cart-items").html(`(${cart.length})`);
		let table = `
        <table class='table'> 
            <thead class='thread-light'>
                <tr>
                    <th>Image</th>
                    <th>Item Name</th>
                    <th>Price</th>
                    <th>Quantity</th>   
                    <th>Total</th>
                    <th>Action</th>
                </tr>
            </thead>`;
		let totalPrice = 0;
		cart.map((item) => {
			table += `
            <tr>
                <td><img src="template/web/img/product/${item.product_image}" width="100" height="100"></td>
                <td>${item.product_name}</td>
                <td>${item.product_price}</td>
                <td><input type='number' min='1' max='10' id="ip" class='quantity' value='${item.product_quantity}'></td>
                <td>${item.product_price * item.product_quantity}</td>
                <td><button onclick='removeItem(${item.product_id})' class="btn btn-danger btn-sm">Remove</button></td>
            </tr>
            `;
			totalPrice += item.product_price * item.product_quantity;
		});

		var docTien = new DocTienBangChu();
		table = table + `
        <tr>
            <td colspan="6" class="text-right" style="color:green; font-family: Verdana; font-size:20px;">
                Total Price: ${totalPrice}
            </td>
        </tr>
            <tr>
                <td colspan="6" class="text-right" style="color:green; font-family: Verdana; font-size:20px;">
                Bằng chữ: ${docTien.doc(totalPrice)}
            </td>
        </tr>          
        </table>`;
		$(".cart-body").html(table);
		$(".checkout-btn").attr('disabled', false);
	}
}


//var quantityInputs = $('.quantity2');//document.getElementsByClassName('quantity2');
//for (var i = 0; i < quantityInputs.length; i++) {
//    var input = quantityInputs[i];
//    input.addEventListener('change', (e) => {
//        console.log("avaaa");
//    });
//}

/*let quantity = document.querySelectorAll('quantity');
quantity.onclick = function (e){
	let quan = quantity.length;
	let cart = localStorage.getItem("cart");
	let pcart = JSON.parse(cart);
	//var input = quantity[i].value;
	let oldProduct = pcart.find((item) => item.product_id == e.target.value);
	console.log(oldProduct)
	for (let i = 0; i < quan; i++) {
		if (oldProduct) {	
			oldProduct.product_quantity = quantity[i].value;
			pcart.map((item) => {
				if (item.product_id == oldProduct.product_id) {
					item.product_quantity = oldProduct.product_quantity;
				}
			});
			localStorage.setItem("cart", JSON.stringify(pcart));
			// console.log("product quantity increased");
		}
	}updateCart();
}*/






/*function increase(pid) {
	let quantity = document.querySelectorAll('quantity');
	let quan = quantity.length;
	console.log(quan);
	let cart = localStorage.getItem("cart");
	let pcart = JSON.parse(cart);
	//var input = quantity[i].value;
	let oldProduct = pcart.find((item) => item.product_id == pid);
		for (let i = 0; i < quan; i++) {
		if (oldProduct) {	
			oldProduct.product_quantity = quantity[i].value;
			pcart.map((item) => {
				if (item.product_id == oldProduct.product_id) {
					item.product_quantity = oldProduct.product_quantity;
				}
			});
			localStorage.setItem("cart", JSON.stringify(pcart));
			// console.log("product quantity increased");
		}
	}/*updateCart();
	
}*/

function removeItem(pid) {
	let cart = JSON.parse(localStorage.getItem('cart'));
	let newCart = cart.filter((item) => item.product_id != pid);
	localStorage.setItem('cart', JSON.stringify(newCart));
	updateCart();
}

$(document).ready(function() {
	updateCart();
});

function Checkout() {
	window.location = "checkout.jsp";
}

var DocTienBangChu = function() {
	this.ChuSo = new Array(" không ", " một ", " hai ", " ba ", " bốn ", " năm ", " sáu ", " bảy ", " tám ", " chín ");
	this.Tien = new Array("", " nghìn", " triệu", " tỷ", " nghìn tỷ", " triệu tỷ");
};

DocTienBangChu.prototype.docSo3ChuSo = function(baso) {
	var tram;
	var chuc;
	var donvi;
	var KetQua = "";
	tram = parseInt(baso / 100);
	chuc = parseInt((baso % 100) / 10);
	donvi = baso % 10;
	if (tram == 0 && chuc == 0 && donvi == 0)
		return "";
	if (tram != 0) {
		KetQua += this.ChuSo[tram] + " trăm ";
		if ((chuc == 0) && (donvi != 0))
			KetQua += " linh ";
	}
	if ((chuc != 0) && (chuc != 1)) {
		KetQua += this.ChuSo[chuc] + " mươi";
		if ((chuc == 0) && (donvi != 0))
			KetQua = KetQua + " linh ";
	}
	if (chuc == 1)
		KetQua += " mười ";
	switch (donvi) {
		case 1:
			if ((chuc != 0) && (chuc != 1)) {
				KetQua += " mốt ";
			} else {
				KetQua += this.ChuSo[donvi];
			}
			break;
		case 5:
			if (chuc == 0) {
				KetQua += this.ChuSo[donvi];
			} else {
				KetQua += " lăm ";
			}
			break;
		default:
			if (donvi != 0) {
				KetQua += this.ChuSo[donvi];
			}
			break;
	}
	return KetQua;
};

DocTienBangChu.prototype.doc = function(SoTien) {
	var lan = 0;
	var i = 0;
	var so = 0;
	var KetQua = "";
	var tmp = "";
	var soAm = false;
	var ViTri = new Array();
	if (SoTien < 0)
		soAm = true;//return "S? ti?n �m !";
	if (SoTien === 0)
		return "Không đồng";//"Kh�ng ??ng !";
	if (SoTien > 0) {
		so = SoTien;
	} else {
		so = -SoTien;
	}
	if (SoTien > 8999999999999999) {
		//SoTien = 0;
		return "";//"S? qu� l?n!";
	}
	ViTri[5] = Math.floor(so / 1000000000000000);
	if (isNaN(ViTri[5]))
		ViTri[5] = "0";
	so = so - parseFloat(ViTri[5].toString()) * 1000000000000000;
	ViTri[4] = Math.floor(so / 1000000000000);
	if (isNaN(ViTri[4]))
		ViTri[4] = "0";
	so = so - parseFloat(ViTri[4].toString()) * 1000000000000;
	ViTri[3] = Math.floor(so / 1000000000);
	if (isNaN(ViTri[3]))
		ViTri[3] = "0";
	so = so - parseFloat(ViTri[3].toString()) * 1000000000;
	ViTri[2] = parseInt(so / 1000000);
	if (isNaN(ViTri[2]))
		ViTri[2] = "0";
	ViTri[1] = parseInt((so % 1000000) / 1000);
	if (isNaN(ViTri[1]))
		ViTri[1] = "0";
	ViTri[0] = parseInt(so % 1000);
	if (isNaN(ViTri[0]))
		ViTri[0] = "0";
	if (ViTri[5] > 0) {
		lan = 5;
	} else if (ViTri[4] > 0) {
		lan = 4;
	} else if (ViTri[3] > 0) {
		lan = 3;
	} else if (ViTri[2] > 0) {
		lan = 2;
	} else if (ViTri[1] > 0) {
		lan = 1;
	} else {
		lan = 0;
	}
	for (i = lan; i >= 0; i--) {
		tmp = this.docSo3ChuSo(ViTri[i]);
		KetQua += tmp;
		if (ViTri[i] > 0)
			KetQua += this.Tien[i];
		if ((i > 0) && (tmp.length > 0))
			KetQua += '';//',';//&& (!string.IsNullOrEmpty(tmp))
	}
	if (KetQua.substring(KetQua.length - 1) === ',') {
		KetQua = KetQua.substring(0, KetQua.length - 1);
	}
	KetQua = KetQua.substring(1, 2).toUpperCase() + KetQua.substring(2);
	if (soAm) {
		return "Âm " + KetQua + " đồng";//.substring(0, 1);//.toUpperCase();// + KetQua.substring(1);
	} else {
		return KetQua + " đồng";//.substring(0, 1);//.toUpperCase();// + KetQua.substring(1);
	}
}
	;