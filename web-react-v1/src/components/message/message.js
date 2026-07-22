import React from "react";

const Message = ({messages}) => {
        console.log("messages");
        console.log(messages);
        
        const message = messages.map((value, index) => {
                                
                return (
                <div key = {index}>
                        user_{value.userId} = {value.content}
                </div>
                );
        });

        return (
        <>
                {message}
        </>
        );

}

export default Message;
