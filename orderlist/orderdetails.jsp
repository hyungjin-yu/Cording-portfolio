<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NAW Order details</title>
<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css" rel="stylesheet">
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../script/OrderdetailsScript.js"></script>
<link rel="stylesheet" href="../css/order_details.css">
</head>
<body id="orderdetail_body">
	<form action="orderdetails.do" method="post" name="form" id="form"
		onsubmit="check(); return false;">
		<div class="allOrderdetails">
			<div class="page-title account-page-title has-text-centered">
				<h1 class="heading is-1">상세 주문 내역</h1>
				<h3>Thank you for your order.</h3>
			</div>

			<h3 class="heading is-5" style="text-align: left;">Order details</h3>
			<div class="text-box-is-top-only-orderDetailContianer">
				<ol class="cart-product-list">
					<li class="account-order-item">
						<div class="cart-product__media" style="display: inline-block; margin-top: 20px;">
							<img src="../storage/${dto.ord_image }" width="220" height="220">
						</div>

						<div class="cart-product__content" data-test="secProducts_Count" style="display: inline-block;">
							<div class="cart-product__context ">
								<div class="cart-product__description">
									<span>${dto.ord_name }</span>
									<p>Size : ${dto.ord_size }</p>
									<p>Color : ${dto.ord_color }</p>
									<p>Price : ${dto.ord_totalprice }원</p>
								</div>
							</div>
						</div>
					</li>
				</ol>
			</div>
			<br> <br>

			<h3 class="heading is-5" style="text-align: left;">Receipt</h3>
			<div class="text-box-orderContainer">
				<div class="well has-text-centered orderTotals">
					<div class="context ">
						<table class="cart-prices">
							<caption></caption>
							<tbody>
								<tr>
									<!--Header-->
									<th scope="row" class="sub-total ">sub Total<br> <span
										class="price-tax">VAT included</span> <br>
									</th>

									<!--Values-->
									<td class="is-bold">
										<!--Regular price--> <!--Discount price--> <span>
											${dto.ord_totalprice }&nbsp;won</span>
									</td>
								</tr>
								<tr></tr>
								<tr></tr>
								<tr>
									<th scope="row" class="">shipping fee<br>
									</th>
									<td class="is-bold">3000 won</td>
								</tr>
								<tr class="is-total">
									<th scope="row" class="">total amount<br> <span
										class="price-tax">VAT included</span>
									</th>
									<td class="is-bold">${dto.ord_totalprice }&nbsp;won<span hidden=""
										class="is-hidden js-order-price">102000.0</span>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<br> <br>

			<div class="customer__content is-narrow has-blocks ">
				<div class="customer__block"
					style="display: inline-block; text-align: left;">
					<div class="text-box delivery-container"
						data-test="secShippingAddress_OrderDetails">
						<div class="heading-block has-xthin-separator">
							<h2 data-test="" class="heading is-5">Shipping fee</h2>
						</div>
						<div class="content-box">
							<h3 class="is-strong">shipping address</h3>
							<div class="has-space">
								<p class="has-no-margin"
									data-test="lblShippingAddress_OrderDetails">${dto.user_name }</p>

								<p class="has-no-margin">${dto.ord_addr2 }</p>
								<p class="has-no-margin">${dto.ord_addr1 }</p>
								<p class="has-no-margin"></p>

								
							</div>

							<h3 class="is-strong">Shipping method</h3>
							<div>
								<p class="has-no-margin"
									data-test="lblShippingMethod_OrderDetails">${dto.ord_payment }</p>
							</div>
						</div>
					</div>
				</div>

				<div class="customer__block">
					<div class="text-box billing_Container"
						data-test="secBillingAddress_OrderDetails">
						<div class="heading-block has-xthin-separator">
							<h2 data-test="" class="heading is-5">Claim</h2>
						</div>
						<div class="content-box">
							<h3 class="is-strong">billing address</h3>
							<div class="has-space">
								<p class="has-no-margin"
									data-test="lblBillingAddress_OrderDetails">${dto.user_name }</p>
								<p class="has-no-margin">${dto.ord_addr2 }</p>
								<p class="has-no-margin">${dto.ord_addr1 }</p>
								<p class="has-no-margin"></p>

							</div>
							<h3 class="is-strong">Payment Method</h3>
							<p class="icon-block has-icon virtual-payment-mode">
								<span class="icon-block__content pay_mode"
									data-test="lblCardDetails">${dto.ord_payment }</span>
							</p>
						</div>
					</div>
				</div>
			</div>
			<div></div>
		</div>
	</form>
</body>
</html>