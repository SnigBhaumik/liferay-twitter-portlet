


<script type="text/javascript">

	function <portlet:namespace/>set_field(url,val){
		//alert("val="+val);
		document.getElementById('<portlet:namespace />fldname').value=val;
		//alert(document.getElementById('<portlet:namespace />field_name').value);
		//alert("url="+url);
		submitForm(document.<portlet:namespace />fm,url);
	}
	function <portlet:namespace />retweetStatus(url,id){
		//alert(id);
		var url=url+"&id="+id;
		var popup=Liferay.Popup(
		{
			title: 'Retweet Message',
			position:[380,150],
			modal:true,
			width:525,
			height:425			
		}
		);
		jQuery(popup).load(url);
	}
	function <portlet:namespace/>updateStatus(url,status,val){
		if(status){																		//for reply
			document.getElementById('<portlet:namespace/>tweet').value="@"+val+":";
		}
		else{																			//for tweet
			document.getElementById('<portlet:namespace/>fldname').value="tweets";			
			submitForm(document.<portlet:namespace />fm,url);
		}
	}
	function <portlet:namespace/>deleteStatus(url,statusid,pageNo,delfrom){
		document.getElementById('<portlet:namespace/>statusId').value=statusid;
		document.getElementById('<portlet:namespace/>fldname').value="delete";
		document.getElementById('<portlet:namespace/>pagingno').value=pageNo;
		document.getElementById('<portlet:namespace/>delfrom').value=delfrom;
		submitForm(document.<portlet:namespace />fm,url);
	}
	function <portlet:namespace />change_style(id,id1){
		document.getElementById(id).style.visibility="visible";
		document.getElementById(id1).style.backgroundColor = "#EFE6E6";
		document.getElementById(id1).style.fontWeight=600;
	}
	function <portlet:namespace />back_style(id,id1){
		document.getElementById(id).style.visibility="hidden";
		document.getElementById(id1).style.backgroundColor = "white";
		document.getElementById(id1).style.fontWeight=100;
	}
	function <portlet:namespace />paging(url,pagingno,prenext,pagingof){
		document.getElementById('<portlet:namespace/>fldname').value="paging";
		document.getElementById('<portlet:namespace/>pagingno').value=pagingno;
		document.getElementById('<portlet:namespace/>prenext').value=prenext;
		document.getElementById('<portlet:namespace/>pagingof').value=pagingof;
		submitForm(document.<portlet:namespace />fm,url);
	}
	function <portlet:namespace />show(id){
		document.getElementById(id).style.visibility="visible";
	}
	function <portlet:namespace />hide(id){
		document.getElementById(id).style.visibility="hidden";
	}
	function <portlet:namespace />back(url){
		submitForm(document.<portlet:namespace />fm,url);
	}
	function <portlet:namespace/>chtxtonmover(id)
	{
		document.getElementById(id).value="Unfollow";
		document.getElementById(id).style.background='red';
	}
	function <portlet:namespace/>chtxtonmoout(id)
	{
		document.getElementById(id).value="Following";
		document.getElementById(id).style.background='#41A317';
	}
	function <portlet:namespace/>set_field_fol_unfol(url,val,fo_un,id){
		document.getElementById('<portlet:namespace/>fldname').value=val;
		document.getElementById('<portlet:namespace/>fol_unfol').value=fo_un;
		document.getElementById('<portlet:namespace/>uId').value=id;
		submitForm(document.<portlet:namespace/>fm,url);
	}
	function check_length(my_form)
	{
		maxLen = 140;
		if (my_form.tweet.value.length > maxLen) {
			my_form.tweet.value = my_form.tweet.value.substring(0, maxLen);
		}
		else{ 
			my_form.text_num.value = maxLen - my_form.tweet.value.length;
		}
	}
	function <portlet:namespace/>retweetMessages(url){
		document.getElementById('<portlet:namespace/>fldname').value="retweet";
		submitForm(document.<portlet:namespace />fm,url);
	}

</script>