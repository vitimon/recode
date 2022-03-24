
import React from "react";

export default function Contents(props) {
    return (
       axios.get(api.baseUrl + props.resource)
    );
}