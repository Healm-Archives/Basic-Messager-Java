const DAY = 24 * 60 * 60 * 1000;

const GroupChat = ({currentGroup, groupChatList, OnSendMessages}) => {
        
        const groupChatListMember = groupChatList.map(gc => {
                let currentTime;
                const thisTimestamp = new Date(gc.timestamp);

                if (Date.now() - Date.parse(gc.timestamp) > 1 * DAY){
                        currentTime = `${thisTimestamp.getDate()}-${thisTimestamp.getMonth() + 1}-${thisTimestamp.getFullYear()}`
                } else {
                        currentTime = `${thisTimestamp.getHours()}-${thisTimestamp.getMinutes()}`
                }

                return (<>
                        <div className="group-chat-section-member">
                                {/* {gc.userUuid}  */}
                                {/* {gc.name} : {gc.content} : {gc.timestamp} */}
                                <img src="/src/assets/react.svg" id="profile-picture" alt="harusnya ad gbr sni" />
                                <div className="group-chat-data">
                                        <div className="group-chat-identifier">
                                                
                                                <div className="group-chat-username">{gc.name}</div>
                                                <div className="group-chat-timestamp">{currentTime}</div>
                                                
                                        </div>
                                        <div className="group-chat-text">
                                                {gc.content}
                                                {/* aadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasd
                                                aadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasd
                                                aadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasd
                                                aadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasd
                                                aadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasd
                                                aadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasd */}
                                        </div>
                                </div>
                        </div>
                        <></>
                </>);
        });

        return (<>
                <div className="group-chat-section">
                        {groupChatListMember}
                        <br />

                        <form action={() => OnSendMessages(currentGroup)} className="group-chat-text-input">
                                {/* <label htmlFor="chatInput">
                                        Type here: 
                                </label> */}
                                <input
                                        id = "chatInput"
                                        name = "chatInput"
                                        type = "text"
                                        placeholder="Type message here"
                                        required
                                />
                                <input
                                        id = "submit"
                                        name = "submit"
                                        type = "submit"
                                />
                        </form>
                </div>
                <></>
        </>);
        

}

export default GroupChat
