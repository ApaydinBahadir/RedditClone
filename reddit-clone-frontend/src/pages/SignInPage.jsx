import React from 'react'
import { Link } from 'react-router-dom'

export default function SignInPage() {
    return (
        <div className="text-center m-5-auto" style={{
            marginLeft: "43em",
        }}>
            <h2>Sign in to us</h2>
            <form action="/home">
                <p>
                    <label>Username</label><br />
                    <input type="text" name="first_name" required />
                </p>
                <p>
                    <label>Password</label>
                    <br />
                    <input type="password" name="password" required />
                </p>
                <p>
                    <button id="sub_btn" type="submit" onClick={() => window.location.href = 'http://localhost:3000/home'}>Login</button>
                </p>
            </form>
        </div>
    )
}
