<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>


        <!-- Carousel
        ================================================== -->
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img class="first-slide home-image" src="<c:url value="/resources/images/cr1.jpg" />" alt="First slide">
                </div>
                <div class="item">
                    <img class="second-slide home-image" src="<c:url value="/resources/images/cr2.jpg" />" alt="Second slide">
                </div>
                <div class="item">
                    <img class="third-slide home-image " src="<c:url value="/resources/images/cr3.jpg" />" alt="Third slide">
                </div>
            </div>
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div><!-- /.carousel -->


        <!-- Marketing messaging and featurettes
        ================================================== -->
        <!-- Wrap the rest of the page in another container to center all the content. -->

		<div class="container marketing">
    	<div class="container">
    	<!-- Three columns of text below the carousel -->
            <div class="row">
                <div class="col-lg-4">
                    <a class="btn btn-default" href="<c:url value="/productlist?searchCondition=Skirts" />" role="button">
                        <img class="img-circle" src="<c:url value="/resources/images/skirts.jpg"/>" alt="Skirts Image" width="140" height="140">
                    </a>

                    <h2>Skirts</h2>

                </div>



                <div class="col-lg-4">
                    <a class="btn btn-default" href="<c:url value="/productlist?searchCondition=Pants" />" role="button">
                        <img class="img-circle" src="<c:url value="/resources/images/pants.jpg"/>" alt="Pants Image" width="140" height="140">
                    </a>

                    <h2>Pants</h2>

                </div>


                <div class="col-lg-4">
                    <a class="btn btn-default" href="<c:url value="/productlist?searchCondition=Shoes" />" role="button">
                        <img class="img-circle" src="<c:url value="/resources/images/shoes.jpg"/>" alt="Shoes Image" width="140" height="140">
                    </a>

                    <h2>Shoes</h2>

                </div>
            </div>
                  <div class="row">
                  
                 <div class="col-lg-4">
                    <a class="btn btn-default" href="<c:url value="/productlist?searchCondition=Accessories" />" role="button">
                        <img class="img-circle" src="<c:url value="/resources/images/accessories.jpg"/>" alt="Accessories Image" width="140" height="140">
                    </a>

                    <h2>Accessories</h2>

                </div>
                  
                  
                <div class="col-lg-4">
                    <a class="btn btn-default" href="<c:url value="/productlist?searchCondition=Uniform" />" role="button">
                        <img class="img-circle" src="<c:url value="/resources/images/bags.jpg"/>" alt="Uniform Image" width="140" height="140">
                    </a>

                    <h2>Bags</h2>

                </div>



                <div class="col-lg-4">
                    <a class="btn btn-default" href="<c:url value="/productlist?searchCondition=Sweaters" />" role="button">
                        <img class="img-circle" src="<c:url value="/resources/images/sweaters.jpg"/>" alt="Sweaters & Cardigans Image" width="140" height="140">
                    </a>

                    <h2>Sweaters & Cardigans</h2>

                </div>



                
            </div>
            <hr/>
            
        
		</div>


<%@ include file="/WEB-INF/views/template/footer.jsp" %>
